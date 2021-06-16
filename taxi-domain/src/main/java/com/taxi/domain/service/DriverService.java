package com.taxi.domain.service;
import com.taxi.domain.mapper.DriverModelMapper;
import com.taxi.domain.model.DriverModel;
import com.taxi.domain.model.PointModel;
import com.taxi.domain.util.CalculateDistance;
import com.taxi.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
    public List<DriverModel> getAllDrivers() {
        return this.driverRepository.findAll().parallelStream().map(DriverModelMapper::mapper).collect(Collectors.toList());
    }
    public List<DriverModel> getAllAvailableDrivers() {
        return this.driverRepository.getAllDriversAvailable().parallelStream().map(DriverModelMapper::mapper).collect(Collectors.toList());
    }
    public List<DriverModel> getAllDrivers3KmOfPoint(PointModel point) {
        return this.driverRepository.findAll().parallelStream().map(DriverModelMapper::mapper).filter(driver ->
                CalculateDistance.distance(point, driver.getLastLocation()) <= 3d
        ).collect(Collectors.toList());
    }
    public DriverModel getDriverById(Long driverId) {
        return this.driverRepository.findById(driverId).map(DriverModelMapper::mapper).orElse(null);
    }
}

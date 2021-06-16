package com.taxi.domain.service;
import com.taxi.domain.mapper.DriverModelMapper;
import com.taxi.domain.mapper.TravelMapper;
import com.taxi.domain.mapper.TravelModelMapper;
import com.taxi.domain.model.*;
import com.taxi.domain.util.CalculateDistance;
import com.taxi.repository.DriverRepository;
import com.taxi.repository.PassengerRepository;
import com.taxi.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private PassengerRepository passengerRepository;
    public TravelModel newTravel(PassengerModel passengerModel) {
        TravelModel travelModel = getDriversSortedByDistance(passengerModel).findFirst().map(d -> createTravel(passengerModel, d)).orElse(null);
        if (Objects.nonNull(travelModel)) {
            this.travelRepository.save(TravelMapper.mapper(travelModel));
        }
        return travelModel;
    }
    private TravelModel createTravel(PassengerModel passengerModel, DistanceKMGeneric<DriverModel> d) {
        TravelModel travelModel = new TravelModel();
        travelModel.setStartDateTime(OffsetDateTime.now());
        travelModel.setStartPoint(passengerModel.getLastLocation());
        travelModel.setDriver(d.getValue());
        travelModel.setPassenger(passengerModel);
        return travelModel;
    }
    public TravelModel completeTravel(TravelModel travelModel, PointModel endPoint) {
        travelModel.setEndPoint(endPoint);
        travelModel.setEndDateTime(OffsetDateTime.now());
        this.travelRepository.save(TravelMapper.mapper(travelModel));
        return travelModel;
    }
    public List<TravelModel> getAllActiveTravels() {
        return this.travelRepository.getAllActives().parallelStream().map(TravelModelMapper::mapper).collect(Collectors.toList());
    }
    public List<DriverModel> getDriverNearby(PassengerModel passengerModel) {
        return getDriversSortedByDistance(passengerModel).limit(3).map(DistanceKMGeneric::getValue).collect(Collectors.toList());
    }
    private Stream<DistanceKMGeneric<DriverModel>> getDriversSortedByDistance(PassengerModel passengerModel) {
        return this.driverRepository.getAllDriversAvailable().stream().map(DriverModelMapper::mapper).map(d -> {
            DistanceKMGeneric<DriverModel> dDriver = new DistanceKMGeneric<>();
            dDriver.setValue(d);
            dDriver.setDistance(CalculateDistance.distance(passengerModel.getLastLocation(), d.getLastLocation()));
            return dDriver;
        }).sorted();
    }
}

package com.taxi.domain.mapper;
import com.taxi.domain.model.DriverModel;
import com.taxi.entities.Driver;
public final class DriverModelMapper {
    private DriverModelMapper() {
        super();
    }
    public static DriverModel mapper(Driver driver) {
        DriverModel driverModel = new DriverModel();
        driverModel.setId(driver.getId());
        driverModel.setName(driver.getName());
        driverModel.setLastName(driver.getLastName());
        driverModel.setDateOfBirth(driver.getDateOfBirth());
        driverModel.setLastLocation(PointModelMapper.mapper(driver.getLastLocation()));
        return driverModel;
    }
}

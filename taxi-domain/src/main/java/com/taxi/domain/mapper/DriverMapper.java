package com.taxi.domain.mapper;
import com.taxi.domain.model.DriverModel;
import com.taxi.entities.Driver;
public final class DriverMapper {
    private DriverMapper() {
        super();
    }
    public static Driver mapper(DriverModel driverM) {
        Driver driver = new Driver();
        driver.setId(driverM.getId());
        driver.setName(driverM.getName());
        driver.setLastName(driverM.getLastName());
        driver.setDateOfBirth(driverM.getDateOfBirth());
        driver.setLastLocation(PointMapper.mapper(driverM.getLastLocation()));
        return driver;
    }
}

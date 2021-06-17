package service;
import com.taxi.domain.model.DriverModel;
import com.taxi.domain.model.PointModel;
import com.taxi.domain.service.DriverService;
import com.taxi.entities.Driver;
import com.taxi.entities.util.Point;
import com.taxi.repository.DriverRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
public class DriverServiceTest {
    @Mock
    private DriverRepository driverRepository;
    @InjectMocks
    private DriverService driverService;
    private List<Driver> diverData;
    private Driver principalDriver;
    @BeforeEach
    public void init() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setDateOfBirth(LocalDate.now());
        Point point = new Point();
        point.setLatitude(123.2131);
        point.setLongitude(1231.1231);
        driver.setLastLocation(point);
        driver.setName("test1");
        driver.setLastName("test1LasName");
        this.principalDriver = driver;
        this.diverData = new ArrayList<>();
        this.diverData.add(driver);
    }
    @Test
    public void getAllDrivers() {
        Mockito.when(this.driverRepository.findAll()).thenReturn(this.diverData);
        List<DriverModel> drivers = this.driverService.getAllDrivers();
        Assertions.assertNotNull(drivers);
        Assertions.assertEquals(drivers.size(), 1);
        Assertions.assertEquals(drivers.get(0).getId(), this.principalDriver.getId());
    }
    @Test
    public void getAllAvailableDrivers() {
        Mockito.when(this.driverRepository.getAllDriversAvailable()).thenReturn(this.diverData);
        List<DriverModel> drivers = this.driverService.getAllAvailableDrivers();
        Assertions.assertNotNull(drivers);
        Assertions.assertEquals(drivers.size(), 1);
        Assertions.assertEquals(drivers.get(0).getId(), this.principalDriver.getId());
    }
    @Test
    public void getAllDrivers3KmOfPoint() {
        PointModel point = new PointModel();
        point.setLatitude(123.2131);
        point.setLongitude(1231.1231);
        Mockito.when(this.driverRepository.findAll()).thenReturn(this.diverData);
        List<DriverModel> drivers = this.driverService.getAllDrivers3KmOfPoint(point);
        Assertions.assertNotNull(drivers);
        Assertions.assertEquals(drivers.size(), 1);
        Assertions.assertEquals(drivers.get(0).getId(), this.principalDriver.getId());
    }
    @Test
    public void getDriverById() {
        Long driverId = 1L;
        Mockito.when(this.driverRepository.findById(driverId)).thenReturn(Optional.of(this.principalDriver));
        DriverModel driver = this.driverService.getDriverById(driverId);
        Assertions.assertNotNull(driver);
        Assertions.assertEquals(driver.getId(), this.principalDriver.getId());
    }
}

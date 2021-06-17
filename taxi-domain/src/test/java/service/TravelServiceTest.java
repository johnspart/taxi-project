package service;
import com.taxi.domain.mapper.PassengerModelMapper;
import com.taxi.domain.mapper.TravelMapper;
import com.taxi.domain.mapper.TravelModelMapper;
import com.taxi.domain.model.*;
import com.taxi.domain.service.TravelService;
import com.taxi.entities.Driver;
import com.taxi.entities.Passenger;
import com.taxi.entities.Travel;
import com.taxi.entities.util.Point;
import com.taxi.repository.DriverRepository;
import com.taxi.repository.PassengerRepository;
import com.taxi.repository.TravelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@ExtendWith(MockitoExtension.class)
public class TravelServiceTest {
    @Mock
    private TravelRepository travelRepository;
    @Mock
    private DriverRepository driverRepository;
    @Mock
    private PassengerRepository passengerRepository;
    @InjectMocks
    private TravelService travelService;
    private Travel principalTravel;
    private Passenger principalPassenger;
    private Driver driver;
    private List<Travel> travelsData;
    private List<Driver> driversData;
    @BeforeEach
    public void init() {
        this.travelsData = new ArrayList<>();
        driversData = new ArrayList<>();
        this.principalTravel = new Travel();
        driver = new Driver();
        driver.setId(2L);
        driver.setDateOfBirth(LocalDate.now());
        Point point = new Point();
        point.setLatitude(-52.2131231231321);
        point.setLongitude(-52.123532523243241);
        driver.setLastLocation(point);
        driver.setName("test2");
        driver.setLastName("test2LasName");
        this.driversData.add(driver);
        driver = new Driver();
        driver.setId(1L);
        driver.setDateOfBirth(LocalDate.now());
        point = new Point();
        point.setLatitude(123.2131);
        point.setLongitude(1231.1231);
        driver.setLastLocation(point);
        driver.setName("test1");
        driver.setLastName("test1LasName");
        this.driversData.add(this.driver);
        this.principalPassenger = new Passenger();
        this.principalPassenger.setId(1L);
        this.principalPassenger.setDateOfBirth(LocalDate.now());
        this.principalPassenger.setLastName("lastName");
        this.principalPassenger.setName("test1Name");
        this.principalTravel.setDriver(driver);
        this.principalTravel.setPassenger(this.principalPassenger);
        this.principalTravel.setEndPoint(point);
        this.principalTravel.setStartDateTime(OffsetDateTime.now());
        this.principalTravel.setEndDateTime(OffsetDateTime.now());
        this.principalTravel.setStartPoint(point);
        this.principalTravel.setId(1L);
        this.travelsData.add(principalTravel);
    }
    @Test
    public void newTravel() {
        PassengerModel passengerModel = PassengerModelMapper.mapper(this.principalPassenger);
        PointModel point = new PointModel();
        point.setLatitude(123.2131);
        point.setLongitude(1231.1231);
        passengerModel.setLastLocation(point);
        Mockito.when(this.driverRepository.getAllDriversAvailable()).thenReturn(this.driversData);
        Mockito.when(this.travelRepository.save(Mockito.any())).thenReturn(this.principalTravel);
        TravelModel newTravel = this.travelService.newTravel(passengerModel);
        Assertions.assertNotNull(newTravel);
        Assertions.assertNull(newTravel.getEndDateTime());
        Assertions.assertTrue(newTravel.getStartDateTime().isAfter(this.principalTravel.getStartDateTime()));
    }
    @Test
    public void completeTravel() {
        TravelModel travelModel = TravelModelMapper.mapper(this.principalTravel);
        PointModel endPoint = new PointModel();
        endPoint.setLatitude(123.2131);
        endPoint.setLongitude(1231.1231);
        Mockito.when(this.travelRepository.save(Mockito.any())).thenReturn(this.principalTravel);
        TravelModel travelComplete = this.travelService.completeTravel(travelModel, endPoint);
        Assertions.assertNotNull(travelComplete);
        Assertions.assertNotNull(travelComplete.getEndDateTime());
        Assertions.assertEquals(travelComplete.getStartDateTime(), this.principalTravel.getStartDateTime());
    }
    @Test
    public void getAllActiveTravels() {
        Mockito.when(this.travelRepository.getAllActives()).thenReturn(this.travelsData);
        List<TravelModel> travels = this.travelService.getAllActiveTravels();
        Assertions.assertNotNull(travels);
        Assertions.assertEquals(travels.size(), 1);
        Assertions.assertEquals(travels.get(0).getStartDateTime(), this.principalTravel.getStartDateTime());
    }
    @Test
    public void getDriverNearby() {
        PassengerModel passengerModel = PassengerModelMapper.mapper(this.principalPassenger);
        PointModel point = new PointModel();
        point.setLatitude(123.2131);
        point.setLongitude(1231.1231);
        passengerModel.setLastLocation(point);
        Mockito.when(this.driverRepository.getAllDriversAvailable()).thenReturn(this.driversData);
        List<DriverModel> driversNearby = this.travelService.getDriverNearby(passengerModel);
        Assertions.assertNotNull(driversNearby);
        Assertions.assertEquals(driversNearby.size(), 2);
        Assertions.assertEquals(driversNearby.get(0).getId(), this.driver.getId());
    }
}

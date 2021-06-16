package service;
import com.taxi.domain.mapper.PassengerModelMapper;
import com.taxi.domain.model.PassengerModel;
import com.taxi.domain.service.PassengerService;
import com.taxi.entities.Passenger;
import com.taxi.repository.PassengerRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@ExtendWith(MockitoExtension.class)
public class PassengerServiceTest {
    @Mock
    private PassengerRepository passengerRepository;
    @InjectMocks
    private PassengerService passengerService;
    private Passenger principalPassenger;
    private List<Passenger> passengers;
    @BeforeEach
    public void init() {
        this.principalPassenger = new Passenger();
        this.principalPassenger.setId(1L);
        this.principalPassenger.setDateOfBirth(LocalDate.now());
        this.principalPassenger.setLastName("lastName");
        this.principalPassenger.setName("test1Name");
        this.passengers = new ArrayList<>();
        this.passengers.add(this.principalPassenger);
    }
    @Test
    public void getAllPassenger() {
        Mockito.when(this.passengerRepository.findAll()).thenReturn(this.passengers);
        List<PassengerModel> passengers = this.passengerService.getAllPassenger();
    }
    @Test
    public void getPassengerById() {
        Long passengerId = 1L;
        Mockito.when(this.passengerRepository.findById(passengerId)).thenReturn(Optional.of(this.principalPassenger));
        PassengerModel passenger = this.passengerService.getPassengerById(passengerId);
    }
}

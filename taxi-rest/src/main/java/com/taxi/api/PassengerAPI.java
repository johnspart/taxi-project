package com.taxi.api;
import com.taxi.domain.model.PassengerModel;
import com.taxi.domain.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/passenger")
public class PassengerAPI {
    @Autowired
    private PassengerService passengerService;
    public Flux<PassengerModel> getAllPassenger() {
        return Flux.fromIterable(this.passengerService.getAllPassenger());
    }
    public Mono<PassengerModel> findPassengerById(Long passengerId) {
        return Mono.just(this.passengerService.getPassengerById(passengerId));
    }
}

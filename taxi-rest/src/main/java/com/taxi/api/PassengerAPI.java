package com.taxi.api;
import com.taxi.domain.model.PassengerModel;
import com.taxi.domain.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/passenger")
public class PassengerAPI {
    @Autowired
    private PassengerService passengerService;
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<PassengerModel> getAllPassenger() {
        return Flux.fromIterable(this.passengerService.getAllPassenger());
    }
    @GetMapping(value = "/findPassengerById/{passengerId}")
    public Mono<PassengerModel> findPassengerById(@PathVariable("passengerId") Long passengerId) {
        return Mono.just(this.passengerService.getPassengerById(passengerId));
    }
}

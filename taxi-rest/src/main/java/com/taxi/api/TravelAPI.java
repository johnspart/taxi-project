package com.taxi.api;
import com.taxi.domain.model.DriverModel;
import com.taxi.domain.model.PassengerModel;
import com.taxi.domain.model.PointModel;
import com.taxi.domain.model.TravelModel;
import com.taxi.domain.service.TravelService;
import com.taxi.util.GenericTwoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/travel")
public class TravelAPI {
    @Autowired
    private TravelService travelService;
    @PostMapping(value = "/newTravel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TravelModel> createNewTravel(@RequestBody PassengerModel passengerModel) {
        return Mono.just(travelService.newTravel(passengerModel));
    }
    @PostMapping(value = "/completeTravel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TravelModel> completeTravel(@RequestBody GenericTwoWrapper<TravelModel, PointModel> wrapperData) {
        return Mono.just(this.travelService.completeTravel(wrapperData.getValueOne(), wrapperData.getValueTwo()));
    }
    @GetMapping(value = "getAllTravelAvailable", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<TravelModel> getAllTravelAvailable() {
        return Flux.fromIterable(this.travelService.getAllActiveTravels());
    }
    @PostMapping(value = "/requestTravel", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<DriverModel> requestTravel(@RequestBody PassengerModel passengerModel) {
        return Flux.fromIterable(this.travelService.getDriverNearby(passengerModel));
    }
}

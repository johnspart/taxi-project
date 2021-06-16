package com.taxi.api;
import com.taxi.domain.model.DriverModel;
import com.taxi.domain.model.PassengerModel;
import com.taxi.domain.model.PointModel;
import com.taxi.domain.model.TravelModel;
import com.taxi.domain.service.TravelService;
import com.taxi.util.GenericTwoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/travel")
public class TravelAPI {
    @Autowired
    private TravelService travelService;
    public Mono<TravelModel> createNewTravel(PassengerModel passengerModel) {
        return Mono.just(travelService.newTravel(passengerModel));
    }
    public Mono<TravelModel> completeTravel(GenericTwoWrapper<TravelModel, PointModel> wrapperData) {
        return Mono.just(this.travelService.completeTravel(wrapperData.getValueOne(), wrapperData.getValueTwo()));
    }
    public Flux<TravelModel> getAllTravelAvailable() {
        return Flux.fromIterable(this.travelService.getAllActiveTravels());
    }
    public Flux<DriverModel> requestTravel(PassengerModel passengerModel) {
        return Flux.fromIterable(this.travelService.getDriverNearby(passengerModel));
    }
}

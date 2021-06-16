package com.taxi.api;
import com.taxi.domain.model.DriverModel;
import com.taxi.domain.model.PointModel;
import com.taxi.domain.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/driver")
public class DriverAPI {
    @Autowired
    private DriverService driverService;

    public Flux<DriverModel> getAllDrivers() {
        return Flux.fromIterable(this.driverService.getAllDrivers());
    }
    public Flux<DriverModel> getAllDriverAvailable() {
        return Flux.fromIterable(this.driverService.getAllAvailableDrivers());
    }
    public Flux<DriverModel> getNearbyDrivers(PointModel point) {
        return Flux.fromIterable(this.driverService.getAllDrivers3KmOfPoint(point));
    }
    public Mono<DriverModel> findDriverById(Long driverId) {
        return Mono.just(this.driverService.getDriverById(driverId));
    }
}

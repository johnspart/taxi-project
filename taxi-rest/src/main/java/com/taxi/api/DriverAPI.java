package com.taxi.api;
import com.taxi.domain.model.DriverModel;
import com.taxi.domain.model.PointModel;
import com.taxi.domain.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/driver")
public class DriverAPI {
    @Autowired
    private DriverService driverService;
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<DriverModel> getAllDrivers() {
        return Flux.fromIterable(this.driverService.getAllDrivers());
    }
    @GetMapping(value = "/getAllAvailable", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<DriverModel> getAllDriverAvailable() {
        return Flux.fromIterable(this.driverService.getAllAvailableDrivers());
    }
    @PostMapping(value = "/getNearby", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<DriverModel> getNearbyDrivers(@RequestBody PointModel point) {
        return Flux.fromIterable(this.driverService.getAllDrivers3KmOfPoint(point));
    }
    @GetMapping(value = "/findById/{driverId}")
    public Mono<DriverModel> findDriverById(@PathVariable("driverId") Long driverId) {
        return Mono.just(this.driverService.getDriverById(driverId));
    }
}

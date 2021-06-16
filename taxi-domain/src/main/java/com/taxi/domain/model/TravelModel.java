package com.taxi.domain.model;
import java.time.OffsetDateTime;
public class TravelModel {
    private Long id;
    private PassengerModel passenger;
    private DriverModel driver;
    private PointModel startPoint;
    private OffsetDateTime startDateTime;
    private PointModel endPoint;
    public OffsetDateTime endDateTime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public PassengerModel getPassenger() {
        return passenger;
    }
    public void setPassenger(PassengerModel passenger) {
        this.passenger = passenger;
    }
    public DriverModel getDriver() {
        return driver;
    }
    public void setDriver(DriverModel driver) {
        this.driver = driver;
    }
    public PointModel getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(PointModel startPoint) {
        this.startPoint = startPoint;
    }
    public OffsetDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(OffsetDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public PointModel getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(PointModel endPoint) {
        this.endPoint = endPoint;
    }
    public OffsetDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(OffsetDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}

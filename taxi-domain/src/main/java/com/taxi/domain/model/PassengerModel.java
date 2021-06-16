package com.taxi.domain.model;
import java.time.LocalDate;
public class PassengerModel {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private PointModel lastLocation;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public PointModel getLastLocation() {
        return lastLocation;
    }
    public void setLastLocation(PointModel lastLocation) {
        this.lastLocation = lastLocation;
    }
}

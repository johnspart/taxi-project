package com.taxi.entities;
import com.taxi.entities.util.Point;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "lastName", length = 255, nullable = false)
    private String lastName;
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    @Embedded
    @Column(name = "last_location", nullable = false)
    private Point lastLocation;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<Travel> travels = new HashSet<>(0);
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
    public Point getLastLocation() {
        return lastLocation;
    }
    public void setLastLocation(Point lastLocation) {
        this.lastLocation = lastLocation;
    }
    public Set<Travel> getTravels() {
        return travels;
    }
    public void setTravels(Set<Travel> travels) {
        this.travels = travels;
    }
}

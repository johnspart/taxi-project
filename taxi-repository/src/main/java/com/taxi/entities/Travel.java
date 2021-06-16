package com.taxi.entities;
import com.taxi.entities.util.Point;

import javax.persistence.*;
import java.time.OffsetDateTime;
@Entity
@Table(name = "travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger", nullable = false)
    private Passenger passenger;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver", nullable = false)
    private Driver driver;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "latitude", column = @Column(name = "start_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "start_longitude"))})
    private Point startPoint;
    @Column(name = "startDateTime", nullable = false)
    private OffsetDateTime startDateTime;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "latitude", column = @Column(name = "end_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "end_longitude"))})
    private Point endPoint;
    @Column(name = "endDateTime")
    public OffsetDateTime endDateTime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Point getStartPoint() {
        return startPoint;
    }
    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
    public OffsetDateTime getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(OffsetDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }
    public Point getEndPoint() {
        return endPoint;
    }
    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
    public OffsetDateTime getEndDateTime() {
        return endDateTime;
    }
    public void setEndDateTime(OffsetDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}

package com.taxi.repository;
import com.taxi.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}

package com.taxi.repository;
import com.taxi.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query("SELECT DRV FROM Driver As DRV WHERE DRV.id NOT IN (SELECT TRV.driver.id FROM Travel As TRV WHERE TRV.endDateTime IS NULL) ")
    List<Driver> getAllDriversAvailable();
    @Query("SELECT DRV FROM Driver As DRV WHERE DRV.id IN (:driversId)")
    List<Driver> getDriversInId(List<Long> driversId);
}

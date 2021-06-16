package com.taxi.repository;
import com.taxi.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface TravelRepository extends JpaRepository<Travel, Long> {
    @Query("SELECT TRV FROM Travel As TRV WHERE TRV.endDateTime IS NULL")
    List<Travel> getAllActives();
}

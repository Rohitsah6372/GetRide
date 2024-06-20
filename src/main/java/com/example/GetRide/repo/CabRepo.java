package com.example.GetRide.repo;

import com.example.GetRide.models.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CabRepo extends JpaRepository<Cab, Integer> {

    @Query(value = "SELECT * FROM Cab WHERE booked = false ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Cab> getRandomAvialableCab();
}

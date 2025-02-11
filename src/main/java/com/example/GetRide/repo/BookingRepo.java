package com.example.GetRide.repo;

import com.example.GetRide.models.Booking;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
    @Query("SELECT b FROM Booking b WHERE b.bookedAt BETWEEN :startOfDay AND :endOfDay")
    List<Booking> findByBookedAtBetween(Date startOfDay, Date endOfDay);
//
    @Query("SELECT b FROM Booking b ORDER BY b.totalFare DESC")
    List<Booking> getTopKHighestFares(Pageable pageable);


    @Query(value = "SELECT b FROM Booking b WHERE b.totalFare > 100 ")
    List<Booking> amountMoreThen();

    @Query("SELECT b FROM Booking b ORDER BY b.totalFare ASC")
    List<Booking> getTopKLowestFares(Pageable pageable);

    @Query("SELECT b FROM Booking b ORDER BY b.totalFare DESC LIMIT 1")
    Booking findCustomerWithHighestFare();

    @Query("SELECT b FROM Booking b ORDER BY b.totalFare ASC LIMIT 1")
    Booking findCustomerWithLowestFare();

    List<Booking> findByBookedAtBetween(Timestamp start, Timestamp end);


}

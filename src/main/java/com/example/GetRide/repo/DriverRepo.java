package com.example.GetRide.repo;

import com.example.GetRide.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, Integer> {

    Driver findByMobileNo(int mobileNo);


    @Query(value = "select d from Driver d where age >= :age")
    public List<Driver> getAllDriversbyAge(int age);

}

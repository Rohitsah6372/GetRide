package com.example.GetRide.repo;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findByEmailId(String email);


    @Query(value = "SELECT c FROM Customer c WHERE c.gender = :gender AND c.age >= :age ")
    public List<Customer> getAllByGenderandAgeGreaterThen(Gender gender, int age);


}

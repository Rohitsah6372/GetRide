package com.example.GetRide.repo;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.dtos.request.response.CustomerResponse;
import com.example.GetRide.models.Customer;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmailId(String emailId);


    @Query(value = "SELECT c FROM Customer c WHERE c.gender = :gender AND c.age >= :age ")
    public List<Customer> getAllByGenderandAgeGreaterThen(Gender gender, int age);

//    Optional<Customer> findByEmailId(String emailId);

    void deleteByEmailId(String emailId);

    List<Customer> findByGenderAndAgeGreaterThan(Gender gender, int age);

    List<Customer> findByAgeBetween(int minAge, int maxAge);

    List<Customer> findByNameContainingIgnoreCase(String name);

    long countByGender(Gender gender);

    List<Customer> findByCreatedAtAfter(LocalDateTime date);

    void deleteAll();


    @Query("SELECT c FROM Customer c") // Explicit query
    List<Customer> getAllCustomers();}

package com.example.GetRide.repo;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.models.Coustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CoustomerRepo extends JpaRepository<Coustomer, Integer> {

    Coustomer findByEmailId(String email);

//    @Query(value = "SELECT * FROM coustomer_details WHERE gender = :gender AND age >= :age", nativeQuery = true)
//    public List<Coustomer> getAllByGenderandAgeGreaterThen(String gender, int age);



    @Query(value = "SELECT c FROM Coustomer c WHERE c.gender = :gender AND c.age >= :age ", nativeQuery = true)
    public List<Coustomer> getAllByGenderandAgeGreaterThen(Gender gender, int age);


}

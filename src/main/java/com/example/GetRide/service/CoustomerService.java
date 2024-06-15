package com.example.GetRide.service;

import com.example.GetRide.dtos.request.CoustomerRequest;
import com.example.GetRide.models.Coustomer;
import com.example.GetRide.repo.CoustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoustomerService {

    @Autowired
    private CoustomerRepo coustomerRepo;



    public Coustomer getCoustomer(String email) {
        return coustomerRepo.findByEmailId(email);
    }

    public String addCoustomer(CoustomerRequest coustomerRequest) {
        Coustomer coustomer = new Coustomer();

        coustomer.setAge(coustomerRequest.getAge());
        coustomer.setName(coustomerRequest.getName());
        coustomer.setNumber(coustomerRequest.getNumber());
        coustomer.setGender(coustomerRequest.getGender());
        coustomer.setEmailId(coustomerRequest.getEmailId());

        Coustomer savedCoustomer = coustomerRepo.save(coustomer);
        return "Coustomer Added Successfully";
    }

    public List<Coustomer> getAllByGenderandAgeGreaterThen(String gender, int age) {
        return coustomerRepo.getAllByGenderandAgeGreaterThen(gender, age);
    }
}

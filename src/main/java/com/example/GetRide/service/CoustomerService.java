package com.example.GetRide.service;

import com.example.GetRide.Enum.Gender;
import com.example.GetRide.Transformer.CoustomerTransformer;
import com.example.GetRide.dtos.request.CoustomerRequest;
import com.example.GetRide.dtos.request.response.CoustomerResponse;
import com.example.GetRide.models.Coustomer;
import com.example.GetRide.repo.CoustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoustomerService {

    @Autowired
    private CoustomerRepo coustomerRepo;



    public CoustomerResponse getCoustomer(String email) {
         Coustomer savedCoustomer = coustomerRepo.findByEmailId(email);
        return CoustomerTransformer.coustomerToCoustomerResponse(savedCoustomer);
    }

    public CoustomerResponse addCoustomer(CoustomerRequest coustomerRequest) {
        Coustomer coustomer = CoustomerTransformer.coustomerRequestToCoustomer(coustomerRequest);
        Coustomer savedCoustomer = coustomerRepo.save(coustomer);
        return CoustomerTransformer.coustomerToCoustomerResponse(coustomer);
    }

    public List<CoustomerResponse> getAllByGenderandAgeGreaterThen(Gender gender, int age) {
        List<Coustomer> saveCoustomer = coustomerRepo.getAllByGenderandAgeGreaterThen(gender, age);
        List<CoustomerResponse> coustomerResponses = new ArrayList<>();
        for(Coustomer coustomer : saveCoustomer){
            coustomerResponses.add(CoustomerTransformer.coustomerToCoustomerResponse(coustomer));
        }
        return coustomerResponses;
    }



}

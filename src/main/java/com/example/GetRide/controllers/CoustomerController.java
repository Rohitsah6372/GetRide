package com.example.GetRide.controllers;


import com.example.GetRide.Enum.Gender;
import com.example.GetRide.dtos.request.CoustomerRequest;
import com.example.GetRide.dtos.request.response.CoustomerResponse;
import com.example.GetRide.service.CoustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coustomer")
public class CoustomerController {

    @Autowired
    CoustomerService coustomerService;

    @PostMapping
    public ResponseEntity addCoustomer(@RequestBody CoustomerRequest coustomerRequest) {
        CoustomerResponse coustomerResponse = coustomerService.addCoustomer(coustomerRequest);
        return new ResponseEntity<>(coustomerResponse, HttpStatus.CREATED);
    }


    @GetMapping
    public CoustomerResponse getCoustomer(@RequestParam("email") String email){
        return coustomerService.getCoustomer(email);
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CoustomerResponse> getAllByGenderandAgeGreaterThen(@PathVariable("gender") Gender gender,
                                                          @PathVariable("age") int age){
        return coustomerService.getAllByGenderandAgeGreaterThen(gender, age);
    }

}

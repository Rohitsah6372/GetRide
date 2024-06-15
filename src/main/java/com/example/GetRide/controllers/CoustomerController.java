package com.example.GetRide.controllers;


import com.example.GetRide.dtos.request.CoustomerRequest;
import com.example.GetRide.models.Coustomer;
import com.example.GetRide.service.CoustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coustomer")
public class CoustomerController {

    @Autowired
    CoustomerService coustomerService;

    @PostMapping("/add")
    public ResponseEntity<String> addCoustomer(@RequestBody CoustomerRequest coustomerRequest) {
        String response = coustomerService.addCoustomer(coustomerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public Coustomer getCoustomer(@RequestParam("email") String email){
        return coustomerService.getCoustomer(email);
    }

    @GetMapping("/get-by-age-gender")
    public List<Coustomer> getAllByGenderandAgeGreaterThen(@RequestParam("gender") String gender,
                                                          @RequestParam("age") int age){
        return coustomerService.getAllByGenderandAgeGreaterThen(gender, age);
    }

}

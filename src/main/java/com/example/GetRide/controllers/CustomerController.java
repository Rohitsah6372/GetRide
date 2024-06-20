package com.example.GetRide.controllers;


import com.example.GetRide.Enum.Gender;
import com.example.GetRide.dtos.request.CustomerRequest;
import com.example.GetRide.dtos.request.response.CustomerResponse;
import com.example.GetRide.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity addCoustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse customerResponse = customerService.addCoustomer(customerRequest);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity getCoustomer(@RequestParam("email") String email){
        CustomerResponse customerResponse = customerService.getCoustomer(email);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getAllByGenderandAgeGreaterThen(@PathVariable("gender") Gender gender,
                                                                  @PathVariable("age") int age){
        return customerService.getAllByGenderandAgeGreaterThen(gender, age);
    }

}

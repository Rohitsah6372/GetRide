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

//
//    @GetMapping("/customer-all")
//    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
//        return new ResponseEntity<>( customerService.getAllCustomers(), HttpStatus.OK);
//    }

    @GetMapping("/gender/{gender}/age/{age}")
    public List<CustomerResponse> getAllByGenderandAgeGreaterThen(@PathVariable("gender") Gender gender,
                                                                  @PathVariable("age") int age){
        return customerService.getAllByGenderandAgeGreaterThen(gender, age);
    }

    @PutMapping("/{email}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable("email") String email,
                                                           @RequestBody CustomerRequest customerRequest) {
        CustomerResponse updatedCustomer = customerService.updateCustomer(email, customerRequest);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("email") String email) {
        customerService.deleteCustomer(email);
        return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/age-range")
    public ResponseEntity<List<CustomerResponse>> getCustomersByAgeRange(@RequestParam("minAge") int minAge,
                                                                         @RequestParam("maxAge") int maxAge) {
        List<CustomerResponse> customers = customerService.getCustomersByAgeRange(minAge, maxAge);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<List<CustomerResponse>> searchCustomersByName(@RequestParam("name") String name) {
        List<CustomerResponse> customers = customerService.searchCustomersByName(name);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/count/gender/{gender}")
    public ResponseEntity<Long> countCustomersByGender(@PathVariable("gender") Gender gender) {
        long count = customerService.countCustomersByGender(gender);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PatchMapping("/deactivate/{email}")
    public ResponseEntity<String> deactivateCustomer(@PathVariable("email") String email) {
        customerService.deactivateCustomer(email);
        return new ResponseEntity<>("Customer account deactivated", HttpStatus.OK);
    }


    @PatchMapping("/reactivate/{email}")
    public ResponseEntity<String> reactivateCustomer(@PathVariable("email") String email) {
        customerService.reactivateCustomer(email);
        return new ResponseEntity<>("Customer account reactivated", HttpStatus.OK);
    }




    @DeleteMapping
    public String deleteALLCoustomer(){
        customerService.deleteALLCoustomer();
        return "Done";
    }



}

package com.example.GetRide.controllers;


import com.example.GetRide.dtos.request.DriverRequest;
import com.example.GetRide.dtos.request.response.DriverResponse;
import com.example.GetRide.models.Driver;
import com.example.GetRide.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping
    public ResponseEntity<String> addDriverandCab(@RequestBody DriverRequest driverRequest){
         String str = driverService.addDriverandCab(driverRequest);
         return new ResponseEntity<>(str, HttpStatus.OK);
    }


    @GetMapping
    public DriverResponse getDriver(@RequestParam("mob-no") int mobileNo){
        return driverService.getDriver(mobileNo);
    }

    @GetMapping("/age/{age}")
    public List<DriverResponse> getAllDriversbyAge(@PathVariable("age") int age){
        return driverService.getAllDriversbyAge(age);

    }



}

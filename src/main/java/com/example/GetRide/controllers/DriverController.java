package com.example.GetRide.controllers;


import com.example.GetRide.dtos.request.DriverRequest;
import com.example.GetRide.models.Driver;
import com.example.GetRide.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity<String> addDriverandCab(@RequestBody DriverRequest driverRequest){
         String str = driverService.addDriverandCab(driverRequest);
         return new ResponseEntity<>(str, HttpStatus.OK);
    }

}

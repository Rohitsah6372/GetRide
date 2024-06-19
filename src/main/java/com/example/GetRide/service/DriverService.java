package com.example.GetRide.service;


import com.example.GetRide.Transformer.CabTransformer;
import com.example.GetRide.Transformer.DriverTransformer;
import com.example.GetRide.dtos.request.DriverRequest;
import com.example.GetRide.dtos.request.response.CabResponse;
import com.example.GetRide.dtos.request.response.DriverResponse;
import com.example.GetRide.models.Cab;
import com.example.GetRide.models.Driver;
import com.example.GetRide.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepo driverRepo;

    public String addDriverandCab(DriverRequest driverRequest) {
        Driver driver = DriverTransformer.driverReqToDriver(driverRequest);
        Cab cab = CabTransformer.cabReqToCab(driverRequest.getCabRequest());
        driver.setCab(cab);
        cab.setDriver(driver);
        //saved Cab and Driver
        driverRepo.save(driver);
        
        return "Driver and Cab Saved successfully";

    }

    public DriverResponse getDriver(int mobileNo) {
        Driver driver = driverRepo.findByMobileNo(mobileNo);
        return DriverTransformer.driverToDriverResponse(driver);

    }

    public List<DriverResponse> getAllDriversbyAge(int age) {
        List<Driver> drivers = driverRepo.getAllDriversbyAge(age);
        List<DriverResponse> driverResponses = new ArrayList<>();
        for(Driver driver : drivers){
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }
}

package com.example.GetRide.Transformer;

import com.example.GetRide.dtos.request.DriverRequest;
import com.example.GetRide.models.Driver;

public class DriverTransformer {

    public static Driver driverReqToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .mobileNo(driverRequest.getMobileNo())
                .drivingLicense(driverRequest.getDrivingLicense())
                .build();
    }


}

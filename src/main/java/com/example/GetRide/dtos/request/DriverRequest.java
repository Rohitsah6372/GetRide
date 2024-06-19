package com.example.GetRide.dtos.request;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


// Getters and Setters

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public  class DriverRequest {

    String name;
    int age;
    int mobileNo;
    String drivingLicense;
    CabRequest cabRequest;



}
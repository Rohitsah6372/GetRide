package com.example.GetRide.dtos.request.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverResponse {

    String name;
    long mobileNo;
    CabResponse cabResponse;
}

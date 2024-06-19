package com.example.GetRide.dtos.request.response;

import com.example.GetRide.Enum.CabType;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabResponse {
    String cabNumber;

    CabType cabType;

    double farePerKm;


    boolean booked;


}

package com.example.GetRide.dtos.request;

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
public class CabRequest {

    String cabNumber;
    CabType cabType;
    double farePerKm;
}

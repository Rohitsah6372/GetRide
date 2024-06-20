package com.example.GetRide.dtos.request;

import com.example.GetRide.Enum.Gender;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {
     int age;
     String name;
     Gender gender;
     String emailId;
}

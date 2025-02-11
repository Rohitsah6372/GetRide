package com.example.GetRide.dtos.request;

import com.example.GetRide.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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

     @Builder.Default
     boolean isActive = true;

     @Builder.Default
     LocalDateTime createdAt = LocalDateTime.now();
}

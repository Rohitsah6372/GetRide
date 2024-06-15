package com.example.GetRide.dtos.request;

import com.example.GetRide.Enum.Gender;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CoustomerRequest {
    private int age;
    private String name;
    private int number;
    private Gender gender;
    private String emailId;

    // Getters and Setters
}

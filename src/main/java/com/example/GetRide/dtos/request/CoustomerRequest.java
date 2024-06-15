package com.example.GetRide.dtos.request;

import com.example.GetRide.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoustomerRequest {
    private int age;
    private String name;
    private int number;
    private Gender gender;
    private String emailId;

    // Getters and Setters
}

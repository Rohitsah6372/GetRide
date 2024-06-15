package com.example.GetRide.dtos.request.response;

import com.example.GetRide.Enum.Gender;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CoustomerResponse {

    private String name;

    private String emailId;

    private Gender gender;
}

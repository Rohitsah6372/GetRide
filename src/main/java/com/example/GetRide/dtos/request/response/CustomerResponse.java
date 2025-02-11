package com.example.GetRide.dtos.request.response;

import com.example.GetRide.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

      String name;

      String emailId;

      Gender gender;

      Boolean Active;

      LocalDateTime createdAt;
}

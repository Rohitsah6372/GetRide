package com.example.GetRide.dtos.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingRequest {

    String pickup;
    String dropLocation;
    double totalDistance;
    String customerEmail; // customer email for finding the customer or we can take anything which is unique

}

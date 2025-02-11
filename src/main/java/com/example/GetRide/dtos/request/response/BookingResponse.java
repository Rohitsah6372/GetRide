package com.example.GetRide.dtos.request.response;

import com.example.GetRide.Enum.BookingStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingResponse {
    String bookingId;
    String pickup;
    String dropLocation;
    BookingStatus bookingStatus;
    double totalDistance;
    double totalFare;
    Date bookedAt;
    CustomerResponse customerResponse;
    DriverResponse driverResponse;
}

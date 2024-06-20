package com.example.GetRide.Transformer;

import com.example.GetRide.Enum.BookingStatus;
import com.example.GetRide.dtos.request.BookingRequest;
import com.example.GetRide.dtos.request.response.BookingResponse;
import com.example.GetRide.models.Booking;
import com.example.GetRide.models.Cab;

import java.util.UUID;

public class BookingTransformer {

    public static Booking bookingReqToBooking(BookingRequest bookingRequest, Cab cab){
        return Booking.builder()
                .bookingId(UUID.randomUUID().toString())
                .pickup(bookingRequest.getPickup())
                .bookingStatus(BookingStatus.CONFIRM)
                .dropLocation(bookingRequest.getDropLocation())
                .totalDistance(bookingRequest.getTotalDistance())
                .totalFare(bookingRequest.getTotalDistance() * cab.getFarePerKm())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking){
        return BookingResponse.builder()
                .bookingId(booking.getBookingId())
                .pickup(booking.getPickup())
                .dropLocation(booking.getDropLocation())
                .bookingStatus(booking.getBookingStatus())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .bookedAt(booking.getBookedAt())
                .customerResponse(CustomerTransformer.coustomerToCoustomerResponse(booking.getCustomer()))
                .driverResponse(DriverTransformer.driverToDriverResponse(booking.getDriver()))
                .build();
    }

}

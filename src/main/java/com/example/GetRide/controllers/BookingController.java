package com.example.GetRide.controllers;


import com.example.GetRide.dtos.request.BookingRequest;
import com.example.GetRide.dtos.request.response.BookingResponse;
import com.example.GetRide.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity bookCab(@PathVariable(value = "coupon-applied", required = false) boolean couponApplied,
                                  @RequestBody BookingRequest bookingRequest){
       try{
           BookingResponse bookingResponse = bookingService.bookCab(bookingRequest);
           return new ResponseEntity(bookingResponse, HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/top-k-lowest/{k}")
    public ResponseEntity<List<BookingResponse>> getTopKLowestFares(@PathVariable int k) {
        return ResponseEntity.ok(bookingService.getTopKLowestFares(k));
    }

    @GetMapping("/highest-fare")
    public ResponseEntity<BookingResponse> getCustomerWithHighestFare() {
        return ResponseEntity.ok(bookingService.getCustomerWithHighestFare());
    }

    @GetMapping("/lowest-fare")
    public ResponseEntity<BookingResponse> getCustomerWithLowestFare() {
        return ResponseEntity.ok(bookingService.getCustomerWithLowestFare());
    }

    @GetMapping("/bookings-today")
    public ResponseEntity<List<BookingResponse>> findBookingsToday() {
        return ResponseEntity.ok(bookingService.findBookingsToday());
    }

}

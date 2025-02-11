package com.example.GetRide.controllers;


import com.example.GetRide.dtos.request.BookingRequest;
import com.example.GetRide.dtos.request.response.BookingResponse;
import com.example.GetRide.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.processing.Find;
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

    @GetMapping("/amount-more-than")
    public List<BookingResponse> amountMoreThen1(){
        return bookingService.amountMoreThen();
    }


    @PutMapping
    public String allBookingCancell(){
        bookingService.allBookingCancell();
        return "Success";
    }


//     Find all the bookings done today
    @GetMapping("/today")
    public ResponseEntity<List<BookingResponse>> getBookingsToday() {
        List<BookingResponse> responses = bookingService.findBookingsToday();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    // Get top k highest fares
    @GetMapping("/highest-fares")
    public ResponseEntity<List<BookingResponse>> getTopKHighestFares(@RequestParam int k) {
        List<BookingResponse> responses = bookingService.getTopKHighestFares(k);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    // Get top k lowest fares
    @GetMapping("/lowest-fares")
    public ResponseEntity<List<BookingResponse>> getTopKLowestFares(@RequestParam int k) {
        List<BookingResponse> responses = bookingService.getTopKLowestFares(k);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    // Get the customer with the highest fare booking
    @GetMapping("/highest-fare-customer")
    public ResponseEntity<BookingResponse> getCustomerWithHighestFare() {
        BookingResponse response = bookingService.getCustomerWithHighestFare();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get the customer with the lowest fare booking
    @GetMapping("/lowest-fare-customer")
    public ResponseEntity<BookingResponse> getCustomerWithLowestFare() {
        BookingResponse response = bookingService.getCustomerWithLowestFare();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

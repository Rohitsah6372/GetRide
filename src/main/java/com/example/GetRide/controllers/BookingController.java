package com.example.GetRide.controllers;


import com.example.GetRide.dtos.request.BookingRequest;
import com.example.GetRide.dtos.request.response.BookingResponse;
import com.example.GetRide.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity bookCab(@RequestBody BookingRequest bookingRequest){
       try{
           BookingResponse bookingResponse = bookingService.bookCab(bookingRequest);
           return new ResponseEntity(bookingResponse, HttpStatus.CREATED);
       }catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

}

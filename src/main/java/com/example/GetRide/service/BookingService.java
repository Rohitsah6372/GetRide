package com.example.GetRide.service;


import com.example.GetRide.Transformer.BookingTransformer;
import com.example.GetRide.dtos.request.BookingRequest;
import com.example.GetRide.dtos.request.response.BookingResponse;
import com.example.GetRide.exception.CabNotFoundException;
import com.example.GetRide.exception.CustomerNotFoundException;
import com.example.GetRide.models.Booking;
import com.example.GetRide.models.Cab;
import com.example.GetRide.models.Customer;
import com.example.GetRide.models.Driver;
import com.example.GetRide.repo.BookingRepo;
import com.example.GetRide.repo.CabRepo;
import com.example.GetRide.repo.CustomerRepo;
import com.example.GetRide.repo.DriverRepo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepo bookingRepo;


    private final CustomerRepo customerRepo;


    private final CabRepo cabRepo;


    private final DriverRepo driverRepo;

    public BookingResponse bookCab(BookingRequest bookingRequest) {
        Customer customer = customerRepo.findByEmailId(bookingRequest.getCustomerEmail());

        if(ObjectUtils.isEmpty(customer)){
            throw new CustomerNotFoundException("Invalid emailId");
        }

        Optional<Cab> optionalCab = cabRepo.getRandomAvialableCab();

        if(optionalCab.isEmpty()){
            throw new CabNotFoundException("Seems Like currently all drivers are occupied!!");
        }

        Cab cab = optionalCab.get();
        Driver driver = cab.getDriver();
        cab.setBooked(true);

        Booking booking = BookingTransformer.bookingReqToBooking(bookingRequest, cab);

        Booking savedBooking = bookingRepo.save(booking);

        customer.getBooking().add(savedBooking);
        driver.getBookings().add(savedBooking);
        booking.setCustomer(customer);
        booking.setDriver(cab.getDriver());

        customerRepo.save(customer); //customer + booking
        driverRepo.save(driver); //driver + booking

        //prepare response Dtos
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }
}

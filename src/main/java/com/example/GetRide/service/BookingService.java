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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepo bookingRepo;
    private final CustomerRepo customerRepo;
    private final CabRepo cabRepo;
    private final DriverRepo driverRepo;

    @Autowired
    JavaMailSender javaMailSender;


    public BookingResponse bookCab(BookingRequest bookingRequest) {
        Customer customer = customerRepo.findByEmailId(bookingRequest.getCustomerEmail())
                .orElseThrow(() -> new CustomerNotFoundException("Invalid emailId"));

        Optional<Cab> optionalCab = cabRepo.getRandomAvialableCab();
        if(optionalCab.isEmpty()){
            throw new CabNotFoundException("Seems Like currently all drivers are occupied!!");
        }
        Cab cab = optionalCab.get();
        Driver driver = cab.getDriver();
        cab.setBooked(true);
        //booking entity
        Booking booking = BookingTransformer.bookingReqToBooking(bookingRequest, cab);
        //for getting the id we have to save it
        Booking savedBooking = bookingRepo.save(booking);
        //customer booking
        customer.getBooking().add(savedBooking);
        //driver booking
        driver.getBookings().add(savedBooking);
        booking.setCustomer(customer);
        booking.setDriver(cab.getDriver());
        customerRepo.save(customer); //customer + booking because of cascade relation
        driverRepo.save(driver); //driver + booking because of cascade relation
        sendEmail(savedBooking);
        //prepare response Dtos
        return BookingTransformer.bookingToBookingResponse(savedBooking);
    }

    //email
    private void sendEmail(Booking savedBooking) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("GetARide@gmail.com");
        simpleMailMessage.setTo(savedBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Booking Confirmed!!");
        simpleMailMessage.setText("Congrats!! " + savedBooking.getCustomer().getName() +
                " Your ride is confirmed " + " Your Booking Id is " + savedBooking.getBookingId());
        javaMailSender.send(simpleMailMessage);

    }

    public List<BookingResponse> amountMoreThen() {
        List<Booking> bookings = bookingRepo.amountMoreThen();
        List<BookingResponse> bookingResponses = new ArrayList<>();

        for(Booking booking : bookings){
            bookingResponses.add(BookingTransformer.bookingToBookingResponse(booking));
        }

        return bookingResponses;
    }

    public void allBookingCancell() {
        List<Cab> cabs = cabRepo.getAllCabs();
        for(Cab cab : cabs){
            cab.setBooked(false);
        }
        cabRepo.saveAll(cabs);
    }


    public List<BookingResponse> getTopKHighestFares(int k) {
        Pageable pageable = PageRequest.of(0, k, Sort.by(Sort.Direction.DESC, "totalFare"));
        List<Booking> topBookings = bookingRepo.getTopKHighestFares(pageable);

        List<BookingResponse> bookingResponses = new ArrayList<>();
        for (Booking booking : topBookings) {
            bookingResponses.add(BookingTransformer.bookingToBookingResponse(booking));
        }

        return bookingResponses;

    }


    public List<BookingResponse> getTopKLowestFares(int k) {
        List<Booking> bookings = bookingRepo.getTopKLowestFares(PageRequest.of(0, k));
        return bookings.stream().map(BookingTransformer::bookingToBookingResponse).toList();
    }

    public BookingResponse getCustomerWithHighestFare() {
        Optional<Booking> booking = Optional.ofNullable(bookingRepo.findCustomerWithHighestFare());
        return booking.map(BookingTransformer::bookingToBookingResponse).orElse(null);
    }

    public BookingResponse getCustomerWithLowestFare() {
        Optional<Booking> booking = Optional.ofNullable(bookingRepo.findCustomerWithLowestFare());
        return booking.map(BookingTransformer::bookingToBookingResponse).orElse(null);
    }

    public List<BookingResponse> findBookingsToday() {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        List<Booking> todayBookings = bookingRepo.findByBookedAtBetween(
                java.sql.Timestamp.valueOf(startOfDay),
                java.sql.Timestamp.valueOf(endOfDay));

        return todayBookings.stream().map(BookingTransformer::bookingToBookingResponse).toList();
    }

}

package com.example.GetRide.models;

import com.example.GetRide.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String bookingId;

    private String pickup;

    private String dropLocation;

    private BookingStatus bookingStatus;


    private double totalDistance;

    private double totalFare;

    @CreationTimestamp
    private Date date;


}

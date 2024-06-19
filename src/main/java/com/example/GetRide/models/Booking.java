package com.example.GetRide.models;

import com.example.GetRide.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int id;

    @Column(unique = true, nullable = false)
     String bookingId;

     String pickup;
     String dropLocation;

     @Enumerated(EnumType.STRING)
     BookingStatus bookingStatus;

     double totalDistance;
     double totalFare;

     @CreationTimestamp
     Date bookedAt;

//    @CreationTimestamp
//     Date date;
//
//    @ManyToOne
//    @JoinColumn
//     Customer coustomer;
//
//    @ManyToOne
//    @JoinColumn
//     Driver driver;

}

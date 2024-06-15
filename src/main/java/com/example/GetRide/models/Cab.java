package com.example.GetRide.models;

import com.example.GetRide.Enum.CabType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.service.annotation.GetExchange;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;


    @Column(unique = true, nullable = false)
     String cabNumber;

     CabType cabType;

     double farePerKm;

     boolean booked;

    @OneToOne
    @JoinColumn
     Driver driver;


}

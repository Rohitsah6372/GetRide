package com.example.GetRide.models;

import com.example.GetRide.Enum.CabType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.service.annotation.GetExchange;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(unique = true, nullable = false)
    private String cabNumber;

    private CabType cabType;

    private double farePerKm;

    private boolean booked;


}

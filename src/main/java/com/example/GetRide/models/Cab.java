package com.example.GetRide.models;

import com.example.GetRide.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.service.annotation.GetExchange;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder
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
    @JsonIgnore
    Driver driver;


}

package com.example.GetRide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "full_name")
     String name;

     int age;
    
    @Column(unique = true, nullable = false)
     int mobileNo;

    @Column(unique = true, nullable = false)
     String drivingLicense;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
     Cab cab;



    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>();

}

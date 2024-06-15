package com.example.GetRide.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String name;

    private int age;

    @Column(unique = true, nullable = false)
    private int mobileNo;

    @Column(unique = true, nullable = false)
    private String drivingLicense;


}

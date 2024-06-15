package com.example.GetRide.models;

import com.example.GetRide.Enum.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "coustomer_details")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Coustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int Id;

     String Name;
     int Number;
     int age;

    @Enumerated(EnumType.STRING)
     Gender gender;

    @Column(unique = true, nullable = false)
     String emailId;

    @OneToMany(mappedBy = "coustomer")
     List<Booking> bookings;

}

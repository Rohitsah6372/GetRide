package com.example.GetRide.models;

import com.example.GetRide.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "coustomer_details")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

     String name;

     int age;

    @Enumerated(EnumType.STRING)
     Gender gender;

    @Column(unique = true, nullable = false)
     String emailId;

    @OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
    List<Booking> booking;

}

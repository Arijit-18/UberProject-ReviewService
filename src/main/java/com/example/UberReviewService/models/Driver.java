package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel{

    private String name;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    //1:many, Driver:Booking
    //mapped by references to the property in the Booking class that we are attaching
    // if we want to fetch data immediately from the tables that we are related to then we use EAGER, else LAZY
    //in 1:1 / many:1 mapping default fetch mode is EAGER
    //in 1:many default fetch mode is LAZY
    //in many:many default fetch mode is LAZY

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT) //this solves the N+1 problem and does the job in a single query
    private List<Booking> bookings = new ArrayList<>();
}

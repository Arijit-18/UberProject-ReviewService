package com.example.UberReviewService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

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
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings = new ArrayList<>();
}

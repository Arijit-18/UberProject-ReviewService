package com.example.UberReviewService.models;

import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel{
    /*
    * One booking has one review and a review belongs to a booking
    * There are 2 ways to handle an enum, string and number
    * */

    //here we are associating an entity as composition, so we need to tell how it should be replicated in the table
    //cascade helps in creation/deletion of dependent objects
    //in 1:1 mapping any one table can have ID of another table
    //in 1:many, the many side has the foreign key in its table
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Review review;

    @Enumerated(value = EnumType.STRING) // this annotation tells spring that this is an enum, and value tells the type it will be stored
    private BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;
}

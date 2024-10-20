package com.example.UberReviewService.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.awt.print.Book;
import java.util.Date;

//ORM like hibernate helps us to create tables in the database by writing class based java code.

//this annotation helps java know that this class is the logical representation of our db table.

//Table annotation is going to manipilate things on the database where as Entity annotation manipulates thing on the java end.

@Getter
@Setter
@Builder //implements the builder pattern
@NoArgsConstructor
@Entity
@Table(name = "booking_review")
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) //creates a single table containing the child and parent properties
//Table per class also does the same but there is a dedicated table for the parent and child contains all the parent properties.
//Joined helps us not to store redundant data again and again

public class Review extends BaseModel {

    @Column(nullable = false)
    private String content;

    private Double rating;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Booking booking;

    @Override
    public String toString() {
        return this.content + " " + this.rating + " " + this.createdAt;
    }
}

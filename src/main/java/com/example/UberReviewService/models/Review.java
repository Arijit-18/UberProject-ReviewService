package com.example.UberReviewService.models;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

//ORM like hibernate helps us to create tables in the database by writing class based java code.

//this annotation helps java know that this class is the logical representation of our db table.

//Table annotation is going to manipilate things on the database where as Entity annotation manipulates thing on the java end.

@Entity
@Table(name = "bookingreview")
public class Review {

    //@Id annotation makes the id property a primary key of our table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity means auto increment
    Long Id;

    @Column(nullable = false)
    String reviewContent;

    Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this tells spring about the format of Date object to be stored i.e Date/Time/Timestamp
    @CreatedDate //this annotation tells spring that only handle for object creation
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //this annotation tells spring that only handle for object updation
    Date updatedAt;
}

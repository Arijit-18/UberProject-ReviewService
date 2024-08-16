package com.example.UberReviewService.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//ORM like hibernate helps us to create tables in the database by writing class based java code.

//this annotation helps java know that this class is the logical representation of our db table.
@Entity
public class Review {

    //@Id annotation makes the id property a primary key of our table
    @Id
//    @GeneratedValue(strategy = )
    Long Id;
}

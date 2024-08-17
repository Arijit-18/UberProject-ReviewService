package com.example.UberReviewService.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//ORM like hibernate helps us to create tables in the database by writing class based java code.

//this annotation helps java know that this class is the logical representation of our db table.

//Table annotation is going to manipilate things on the database where as Entity annotation manipulates thing on the java end.

@Getter
@Setter
@Builder //implements the builder pattern
@NoArgsConstructor
@Entity
@Table(name = "bookingreview")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
public class Review {

    //@Id annotation makes the id property a primary key of our table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity means auto increment
    private Long Id;

    @Column(nullable = false)
    private String reviewContent;

    private Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this tells spring about the format of Date object to be stored i.e Date/Time/Timestamp
    @CreatedDate //this annotation tells spring that only handle for object creation
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //this annotation tells spring that only handle for object updation
    private Date updatedAt;

    @Override
    public String toString() {
        return this.reviewContent + " " + this.rating + " " + this.createdAt;
    }
}

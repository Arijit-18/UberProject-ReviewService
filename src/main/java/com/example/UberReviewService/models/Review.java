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
@AllArgsConstructor
public class Review extends BaseModel {

    @Column(nullable = false)
    private String reviewContent;

    private Double rating;

    @Override
    public String toString() {
        return this.reviewContent + " " + this.rating + " " + this.createdAt;
    }
}

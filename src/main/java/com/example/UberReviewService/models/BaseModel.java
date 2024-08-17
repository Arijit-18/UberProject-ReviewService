package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


/*
The bare minimum properties that could be used in other models are segregated out in this model class.
We are creating this class as abstract because we don't want any other class to create an object of it even by mistake.

------------------Handling inheritance in spring data jpa-----------
MappedSuperclass(it is given to the base model/class) -> 1. No table for parent class
2. One table for each child class having its own attributes and parent class attribute
*/


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    //@Id annotation makes the id property a primary key of our table
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity means auto increment
    private Long Id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this tells spring about the format of Date object to be stored i.e Date/Time/Timestamp
    @CreatedDate //this annotation tells spring that only handle for object creation
    protected Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate //this annotation tells spring that only handle for object updation
    protected Date updatedAt;
}

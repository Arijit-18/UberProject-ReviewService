package com.example.UberReviewService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PassengerReview extends Review{
    //in a single table nullable=false is not applicable

    @Column(nullable = false)
    private String passengerReviewContent;

    @Column(nullable = false)
    private String passengerRating;
}

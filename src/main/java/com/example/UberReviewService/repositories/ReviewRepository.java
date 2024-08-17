package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repository layer communicates with DB
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}

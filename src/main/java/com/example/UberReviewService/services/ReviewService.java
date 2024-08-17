package com.example.UberReviewService.services;


import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("******");
        Review r = Review.builder().reviewContent("Amazing ride quality").rating(5.0).build(); //code to create plain jave obj
        System.out.println(r);
        reviewRepository.save(r); //this code executes sql query

        List<Review> reviews = reviewRepository.findAll();
        for(Review review: reviews)
        {
            System.out.println(r.getReviewContent());
        }
    }
}

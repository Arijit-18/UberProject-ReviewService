package com.example.UberReviewService.services;


import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("******");

        Review r = Review.builder().reviewContent("Amazing ride quality").rating(5.0).build(); //code to create plain jave obj

        //here we are adding r object into our b object, but till now r object is not available in the table
        // we are trying to save the booking data with a review without even creating a review first
        Booking b = Booking
                .builder()
                .review(r)
                .endTime(new Date())
                .build();

//        reviewRepository.save(r); //this code executes sql query
        bookingRepository.save(b); //this saves the booking in db


        System.out.println(r);
        List<Review> reviews = reviewRepository.findAll();
        for(Review review: reviews)
        {
            System.out.println(r.getReviewContent());
        }
    }
}

package com.example.UberReviewService.services;


import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;
    private DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("******");

//        Review r = Review.builder().reviewContent("Amazing ride quality").rating(5.0).build(); //code to create plain jave obj

        //here we are adding r object into our b object, but till now r object is not available in the table
        // we are trying to save the booking data with a review without even creating a review first
//        Booking b = Booking
//                .builder()
//                .review(r)
//                .endTime(new Date())
//                .build();

//        reviewRepository.save(r); //this code executes sql query
//        bookingRepository.save(b); //this saves the booking in db
//
//
//        System.out.println(r);
//        List<Review> reviews = reviewRepository.findAll();
//        for(Review review: reviews)
//        {
//            System.out.println(r.getReviewContent());
//        }

//        Optional<Driver> driver =  driverRepository.findById(1L);
//        if(driver.isPresent()) {
//            System.out.println(driver.get().getName());
//            List<Booking> b = driver.get().getBookings();
//
////            List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//            for(Booking booking: b)
//            {
//                System.out.println(booking.getId());
//            }
//        }

        Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L, "JH097235");
        System.out.println(d.get().getName());
    }
}

package com.example.UberReviewService.services;


import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.*;

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
    @Transactional
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

//        Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L, "JH097235");
//        System.out.println(d.get().getName());
//        List<Long> driverIds = new ArrayList<>(Arrays.asList(1L, 2L, 5L, 6L));
//        List<Driver> drivers = driverRepository.findAllByIdIn(driverIds);

//        List<Booking> bookings = bookingRepository.findAllByDriverIn(drivers);

        //to execute one query we are executing more n+1 queries, this is called the n+1 problem
//        for(Driver driver : drivers) {
//           List<Booking> bookings = driver.getBookings();
//           bookings.forEach(booking -> System.out.println(booking.getId()));
//        }
    }

}

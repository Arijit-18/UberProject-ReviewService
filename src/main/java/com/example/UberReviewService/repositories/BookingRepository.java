package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    //commented these because reviewService is not supposed to fetch driver centric data
//    List<Booking> findAllByDriverId(Long driverId);
//
//    List<Booking> findAllByDriverIn(List<Driver> drivers);
}

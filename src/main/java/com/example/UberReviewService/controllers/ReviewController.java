package com.example.UberReviewService.controllers;

import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewService2 reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;
    public ReviewController(ReviewService2 reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter)
    {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> publishReview(@RequestBody CreateReviewDto request) {
        Review incomingReview = this.createReviewDtoToReviewAdapter.convertDto(request);
        System.out.println(incomingReview);
        if(incomingReview == null) {
            return new ResponseEntity<>("Invalid Args", HttpStatus.BAD_REQUEST);
        }
        Review review = this.reviewService.publishReview(incomingReview);

        ReviewDto response = ReviewDto
                .builder()
                .id(review.getId())
                .content(review.getContent())
                .booking(review.getBooking().getId())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> getReviewById(@PathVariable Long reviewId) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId) {
        try {
            boolean isDeleted = this.reviewService.deleteReviewById(reviewId);
            if(!isDeleted) return new ResponseEntity<>("Unable to delete Review", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

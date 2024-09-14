package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService2{

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository)
    {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        Optional<Review> review;
        try {
            review = this.reviewRepository.findById(id);
            if(review.isEmpty())
                throw new EntityNotFoundException("Review with Id " + id + " not found");
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class) {
                throw new FetchNotFoundException("Review with Id " + id + " not found", id);
            }
            throw new FetchNotFoundException("Unable to fetch, PLease try again later!", id);
        }

        return review;
    }

    @Override
    public Review publishReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            this.reviewRepository.delete(review);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Review updateReview(Long id, Review newReview) {
        Review review = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(newReview.getRating() != null) {
            review.setRating(newReview.getRating());
        }

        if(newReview.getContent() != null) {
            review.setRating(newReview.getRating());
        }

        return this.reviewRepository.save(review);
    }
}

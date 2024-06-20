package com.job.comapany.job.service;

import com.job.comapany.job.domain.Rating;
import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.domain.Review;
import com.job.comapany.job.domain.client.RestaurantClient;
import com.job.comapany.job.repository.RatingRepository;
import com.job.comapany.job.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReviewServiceImp implements ReviewService{
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final RatingRepository ratingRepository;
    @Autowired
    private final RestaurantClient restaurantClient;
    @Override
    public String addReview(Review review) {
//        boolean addReviews = reviewRepository.save(review);
        // Business logic to validate and save the review
//        if (review)
        reviewRepository.save(review);
        return("success");
    }
    @Override
    public Rating addRating(Rating rating) {
        // Business logic to validate and save the rating
        return ratingRepository.save(rating);

    }
//    @Override
//    public Map<String, Object> getReviewsByRestaurantId(Long restaurantId) {
//        List<Review>reviews = reviewRepository.findByRestaurantId(restaurantId);
//        Restaurant restaurant = restaurantClient.getRestaurantById(restaurantId);
//
//        Map<String, Object>response = new HashMap<>();
//        response.put("restaurant", restaurant);
//        response.put("review", reviews);
//
//        return response;
//    }
//    @Override
//    public List<Rating> getRatingsByRestaurantId(Long restaurantId) {
//        return ratingRepository.findByRestaurantId(restaurantId);
//    }
    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantClient.getRestaurantById(restaurantId);
    }

    @Override
    public Map<String, Object> getReviewsAndRatingsByRestaurantId(Long restaurantId) {
        List<Review> reviews = reviewRepository.findByRestaurantId(restaurantId);
        Restaurant restaurant = restaurantClient.getRestaurantById(restaurantId);
        List<Rating> ratings = ratingRepository.findByRestaurantId(restaurantId);

        // Combine reviews, ratings, and restaurant details into a single response object
        Map<String, Object> response = new HashMap<>();
        response.put("restaurant", restaurant);
        response.put("reviews", reviews);
        response.put("ratings", ratings);

        return response;
    }
}

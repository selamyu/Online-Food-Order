package com.job.comapany.job.controller;

import com.job.comapany.job.domain.Rating;
import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.domain.Review;
import com.job.comapany.job.messaging.ReviewMessageProducer;
import com.job.comapany.job.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;
    @Autowired
    private final ReviewMessageProducer reviewMessageProducer;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<Map<String, Object>> getReviewsByRestaurantId(@PathVariable Long restaurantId) {
        Map<String, Object> response = reviewService.getReviewsAndRatingsByRestaurantId(restaurantId);
        return ResponseEntity.ok(response);
    }
//    @GetMapping("/restaurant/{restaurantId}")
//    public ResponseEntity<Map<String, Object>> getReviewsByRestaurantId(@PathVariable Long restaurantId) {
//        Map<String, Object>response = reviewService.getReviewsByRestaurantId(restaurantId);
//        return ResponseEntity.ok(response);
//
//        List<Review> reviews = reviewService.getReviewsByRestaurantId(restaurantId);
//        Restaurant restaurant = reviewService.getRestaurantById(restaurantId);
//        return ResponseEntity.ok(reviews);
//    }

//    @GetMapping("/restaurant/{restaurantId}/ratings")
//    public ResponseEntity<List<Rating>> getRatingsByRestaurantId(@PathVariable Long restaurantId) {
//        List<Rating> ratings = reviewService.getRatingsByRestaurantId(restaurantId);
//        return ResponseEntity.ok(ratings);
//    }

    @PostMapping("/addReview")
    public ResponseEntity<String> addReview(@RequestBody Review review) {

        boolean addedReview = Boolean.parseBoolean(reviewService.addReview(review));
        if (addedReview){
            reviewMessageProducer.sendMessage(review);
        }
        return new ResponseEntity<>("review added successfully", HttpStatus.OK);
    }

    @PostMapping("/addRating")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
        Rating addedRating = reviewService.addRating(rating);
        return ResponseEntity.ok(addedRating);
    }
}

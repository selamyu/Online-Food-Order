package com.job.comapany.job.service;

import com.job.comapany.job.domain.Rating;
import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.domain.Review;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    String addReview(Review review);

    Rating addRating(Rating rating);
//    Map<String, Object> getReviewsByRestaurantId(Long restaurantId);

//    List<Rating> getRatingsByRestaurantId(Long restaurantId);

    Restaurant getRestaurantById(Long restaurantId);

    Map<String, Object> getReviewsAndRatingsByRestaurantId(Long restaurantId);
}

package com.job.comapany.job.service;

import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.dto.ReviewMessage;

import java.util.List;

public interface RestaurantService {
    void addRestaurant(Restaurant restaurant);

    List fetchRestaurants();

    Restaurant getRestaurantById(Long id);

    void updateRestaurant(ReviewMessage reviewMessage);
}

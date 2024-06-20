package com.job.comapany.job.service;

import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.dto.ReviewMessage;
import com.job.comapany.job.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private final RestaurantRepository repository;

    @Override
    public void addRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> fetchRestaurants() {
        return repository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void updateRestaurant(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getComment());
        Restaurant restaurant = repository.findById(reviewMessage.getRestaurantId()).orElseThrow();
    }
}

package com.job.comapany.job.controller;

import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.exceptionHandler.RestaurantNotFoundException;
import com.job.comapany.job.service.RestaurantService;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private final RestaurantService service;
    @PostMapping
    public ResponseEntity<String>addRestaurant(@RequestBody Restaurant restaurant){
        service.addRestaurant(restaurant);
        return new ResponseEntity<>("restaurant added successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List> getAllRestaurants(){
        return new ResponseEntity<>(service.fetchRestaurants(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getRestaurantById(id), HttpStatus.OK);
    }
}

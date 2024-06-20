package com.job.comapany.job.domain.client;

import com.job.comapany.job.domain.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "restaurant-service", url = "${restaurant-service.url}")
public interface RestaurantClient {
    @GetMapping("/restaurant/{id}")
//   @GetMapping("/{id}")
    Restaurant getRestaurantById(@PathVariable("id") Long id);
}

package com.job.comapany.job.domain.client;

//import com.job.comapany.job.domain.Restaurant;
import com.job.comapany.job.domain.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//now we will replace url = "http://localhost:4040" with the below url
@FeignClient(name = "restaurant-service", url = "${restaurant-service.url}")
public interface RestaurantClient {
   @GetMapping("/restaurant/{id}")
//   @GetMapping("/{id}")
   RestaurantDTO getRestaurantById(@PathVariable("id") Long id);
}

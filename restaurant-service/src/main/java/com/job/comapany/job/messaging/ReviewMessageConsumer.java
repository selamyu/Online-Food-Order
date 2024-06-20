package com.job.comapany.job.messaging;

import com.job.comapany.job.dto.ReviewMessage;
import com.job.comapany.job.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewMessageConsumer {
    private final RestaurantService restaurantService;

    @RabbitListener(queues = "restaurantRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){
        restaurantService.updateRestaurant(reviewMessage);

    }
}

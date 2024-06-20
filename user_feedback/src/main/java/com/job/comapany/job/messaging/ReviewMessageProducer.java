package com.job.comapany.job.messaging;

import com.job.comapany.job.domain.Review;
import com.job.comapany.job.dto.ReviewMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(Review review){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(review.getId());
        reviewMessage.setCustomerId(review.getCustomerId());
        reviewMessage.setRestaurantId(review.getRestaurantId());
        reviewMessage.setRating(review.getRating());
        reviewMessage.setDate(review.getDate());
        reviewMessage.setComment(review.getComment());

        rabbitTemplate.convertAndSend("restaurantRatingQueue", reviewMessage);
    }
}

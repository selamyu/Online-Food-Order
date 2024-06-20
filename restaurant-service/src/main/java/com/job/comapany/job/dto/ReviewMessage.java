package com.job.comapany.job.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ReviewMessage {
    private Long id;
    private Long customerId;
    private Long restaurantId;
    private double rating;
    private String comment;

    private LocalDateTime date;
}

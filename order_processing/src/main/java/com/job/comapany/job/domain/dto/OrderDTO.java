package com.job.comapany.job.domain.dto;

import com.job.comapany.job.domain.OrderItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class OrderDTO {
    private Long id;
    private String customerName;
    private double totalPrice;
    private Long restaurantId;
    //    @Transient
//    private Restaurant restaurant;
//    private OrderStatuses statuses;
//    @JsonIgnore
}

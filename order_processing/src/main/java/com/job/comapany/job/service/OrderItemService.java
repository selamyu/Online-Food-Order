package com.job.comapany.job.service;

import com.job.comapany.job.domain.OrderItem;

public interface OrderItemService {
    void addOrderItems(OrderItem orderItem);

    Object getOrderItems();

    void deleteById(Long id);
}

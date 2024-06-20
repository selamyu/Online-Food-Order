package com.job.comapany.job.service;

import com.job.comapany.job.domain.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery createDelivery(Delivery delivery);

    List<Delivery> getAllDeliveries();

    Delivery getDeliveryById(Long id);
    List<Delivery> getDeliveriesByOrderId(Long orderId);

    void deleteDelivery(Long id);

}

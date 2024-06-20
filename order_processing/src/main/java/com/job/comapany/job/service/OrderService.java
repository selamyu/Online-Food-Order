package com.job.comapany.job.service;

//import com.job.comapany.job.domain.Delivery;
import com.job.comapany.job.domain.Order;
//import com.job.comapany.job.domain.dto.OrderRestaurantDTO;
import com.job.comapany.job.domain.OrderStatus;
import com.job.comapany.job.domain.dto.RestaurantDTO;
//import com.job.comapany.job.domain.dto.RestaurantDTO;

//import com.job.comapany.job.domain.dto.OrderDTO;

import java.util.Map;

public interface OrderService {
    Order createOrder(Order order);

    Object getOrders();

    void deleteById(Long id);

    Order getOrderById(Long id);

    RestaurantDTO getRestaurantByOrderId(Long orderId);

//    OrderWithRestaurantResponseDTO getOrderWithRestaurant(Long orderId);

//    List<Delivery> getDeliveriesByOrderId(Long orderId);

    Map<String, Object> getOrderWithRestaurantAndDeliveries(Long orderId);

    Order updateOrderStatus(Long orderId, OrderStatus status);

//    Restaurant getRestaurantByOrderId(Long orderId);
//    Restaurant getRestaurantByOrderId(Long id);
//   ResponseEntity<Restaurant> getRestaurantDetailsByOrderId(Long orderId);

//    List<Order> getOrdersByRestaurantId(Long restaurantId);
}

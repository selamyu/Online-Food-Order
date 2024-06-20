package com.job.comapany.job.controller;

import com.job.comapany.job.domain.*;
//import com.job.comapany.job.domain.Order;
//import com.job.comapany.job.domain.dto.OrderDTO;
//import com.job.comapany.job.domain.dto.OrderRestaurantDTO;
//import com.job.comapany.job.domain.dto.OrderWithRestaurantResponseDTO;
//import com.job.comapany.job.domain.dto.RestaurantDTO;
//import com.job.comapany.job.service.OrderService;
import com.job.comapany.job.domain.dto.RestaurantDTO;
import com.job.comapany.job.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService service;
    @PostMapping
    public ResponseEntity<Order>createOrder(@RequestBody Order order){
        service.createOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Order>getAllOrders(){
        return new ResponseEntity(service.getOrders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id){
        Order order = service.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        Order updatedOrder = service.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }
    @GetMapping("/{orderId}/restaurant")
    public ResponseEntity<RestaurantDTO> getRestaurantByOrderId(@PathVariable Long orderId) {
        return new ResponseEntity<>(service.getRestaurantByOrderId(orderId), HttpStatus.CREATED);
    }
//    @GetMapping("/{orderId}/with-restaurant")
//    public ResponseEntity<OrderWithRestaurantResponseDTO> getOrderWithRestaurant(@PathVariable Long orderId) {
//        OrderWithRestaurantResponseDTO response = service.getOrderWithRestaurant(orderId);
//        return ResponseEntity.ok(response);
//    }

    //we can also do like this:

    @GetMapping("/{orderId}/details")
    public ResponseEntity<Map<String, Object>> getOrderWithRestaurantAndDeliveries(@PathVariable Long orderId) {
        Map<String, Object> response = service.getOrderWithRestaurantAndDeliveries(orderId);
        return ResponseEntity.ok(response);
    }

//    @GetMapping("/{orderId}/deliveries")
//    public ResponseEntity<List<Delivery>>getDeliveriesByOrderId(@PathVariable Long orderId) {
//        List<Delivery> deliveries = service.getDeliveriesByOrderId(orderId);
//        return ResponseEntity.ok(deliveries);
//    }
    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id){
        service.deleteById(id);
    }
}

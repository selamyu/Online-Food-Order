package com.job.comapany.job.controller;

import com.job.comapany.job.domain.Order;
import com.job.comapany.job.domain.OrderItem;
import com.job.comapany.job.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor
public class OrderItemController {
    @Autowired
    private final OrderItemService service;

    @PostMapping
    public ResponseEntity<String> addOrderItems(@RequestBody OrderItem orderItem){
        service.addOrderItems(orderItem);
        return new ResponseEntity<>("order item is added", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Order>getAllOrders(){
        return new ResponseEntity(service.getOrderItems(), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id){
        service.deleteById(id);
    }
}

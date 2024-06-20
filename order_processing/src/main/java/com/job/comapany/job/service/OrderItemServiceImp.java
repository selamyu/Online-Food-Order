package com.job.comapany.job.service;

import com.job.comapany.job.domain.Order;
import com.job.comapany.job.domain.OrderItem;
import com.job.comapany.job.repository.OrderItemRepository;
import com.job.comapany.job.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImp implements OrderItemService {
    @Autowired
    private final OrderItemRepository repository;

    @Override
    public void addOrderItems(OrderItem orderItem) {
        repository.save(orderItem);
    }

    @Override
    public Object getOrderItems() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
        throw new RuntimeException("sorry order item id not found");
    }
}

package com.job.comapany.job.service;

import com.job.comapany.job.domain.*;
import com.job.comapany.job.domain.Order;
//import com.job.comapany.job.domain.client.DeliveryClient;
import com.job.comapany.job.domain.client.RestaurantClient;
//import com.job.comapany.job.domain.dto.OrderDTO;
//import com.job.comapany.job.domain.dto.OrderRestaurantDTO;
import com.job.comapany.job.domain.dto.RestaurantDTO;
import com.job.comapany.job.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{
    private final OrderRepository repository;
    private final RestaurantClient restaurantClient;
//    @Autowired
//    private ModelMapper mapper;
//    private final DeliveryClient deliveryClient;
    @Override
    public Order createOrder(Order order) {
        order.setStatus(OrderStatus.PENDING);
        order.setOrderDate(LocalDateTime.now());
        return repository.save(order);
    }
    @Override
    public Object getOrders() {
        return repository.findAll();
    }
    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new RuntimeException("sorry order id not found");
        }
        //second option
//        Object checkOrder = repository.existsById(id) ? repository : new RuntimeException("order not found");

    }

    @Override
    public Order getOrderById(Long id) {
        return repository.findById(id).orElseThrow(() ->new RuntimeException("order not found"));

//        Order order= repository.findById(id).orElseThrow();

//        ResponseEntity<Restaurant> response = restaurantClient.getRestaurantById(id);
//        if (response.getStatusCode() == HttpStatus.OK) {
//            order.setRestaurant(response.getBody());
//        } else {
//            throw new RuntimeException("Failed to fetch restaurant details");
//        }
//        Order order = new Order();
//        order.setCustomerName(order.getCustomerName());
//        order.setItems(order.getItems());
//        order.setTotalPrice(order.getTotalPrice());
//
//        return order;
//        return repository.findById(id).orElseThrow();
    }

    @Override
    public RestaurantDTO getRestaurantByOrderId(Long orderId) {
        Order order = getOrderById(orderId);
        return restaurantClient.getRestaurantById(order.getRestaurantId());
    }
//
//    @Override
//    public Restaurant getRestaurantByOrderId(Long orderId) {
//        Optional<Order> order = repository.findById(orderId);
////        return restaurantClient.getRestaurantById(order.getRestaurantId());
//        return order.map(o -> restaurantClient.getRestaurantById(o.getRestaurantId()));
//    }

//    @Override
//    public OrderWithRestaurantResponseDTO getOrderWithRestaurant(Long orderId) {
//        Order order = repository.findById(orderId)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        RestaurantDTO restaurant = restaurantClient.getRestaurantById(order.getRestaurantId());
//
//        OrderDTO orderDTO = new OrderDTO();
////        orderDTO.setOrderId(order.getId());
//        orderDTO.setId(order.getId());
//        orderDTO.setCustomerName(order.getCustomerName());
//        orderDTO.setTotalPrice(order.getTotalPrice());
//        orderDTO.setRestaurantId(restaurant.getId());
////        orderRestaurantDTO.setRestaurantName(restaurant.getName());
////        orderRestaurantDTO.setRestaurantAddress(restaurant.getAddress());
////        orderRestaurantDTO.setRestaurantDescription(restaurant.getDescription());
////        orderRestaurantDTO.setRestaurantRating(restaurant.getRating());
//
//        OrderWithRestaurantResponseDTO responseDTO = new OrderWithRestaurantResponseDTO();
//        responseDTO.setRestaurant(restaurant);
//        responseDTO.setOrder(orderDTO);
//
//        // we can do it using Hash map
//
//        return responseDTO;
//    }

//    @Override
//    public List<Delivery> getDeliveriesByOrderId(Long orderId) {
//        return deliveryClient.getDeliveriesByOrderId(orderId);
//    }

    @Override
    public Map<String, Object> getOrderWithRestaurantAndDeliveries(Long orderId) {
        Order order = getOrderById(orderId);
        RestaurantDTO restaurant = getRestaurantByOrderId(orderId);
//        List<Delivery> deliveries = getDeliveriesByOrderId(orderId);

        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("restaurant", restaurant);
//        response.put("deliveries", deliveries);

        return response;
    }

    @Override
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Optional<Order> optionalOrder = repository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setStatus(status);
            return repository.save(order);
        } else {
            throw new RuntimeException("Order not found");
        }
    }


//    @Override
//    public ResponseEntity<Restaurant> getRestaurantDetailsByOrderId(Long orderId) {
//        // Call the Feign client to fetch restaurant details
//        return restaurantClient.getRestaurantByOrderId(orderId);
//    }
//    @Override
//    public Restaurant getRestaurantByOrderId(Long id) {
//        return restaurantClient.getRestaurantByOrderId(id).getBody();
//    }

//    @Override
//    public List<Order> getOrdersByRestaurantId(Long restaurantId) {
//        return repository.findByRestaurantId(restaurantId);
//    }

    //    public Restaurant getRestaurantById(Long id){
//        return restaurantClient.getRestaurantById(id);
//    }
//    public List<Delivery> getDelivery(@RequestParam("restaurantId") Long restaurantId){
//        return deliveryClient.getDelivery(restaurantId);
//    }
}

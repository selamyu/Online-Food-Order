//package com.job.comapany.job.domain.client;
//
//import com.job.comapany.job.domain.Delivery;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@FeignClient(name = "delivery-service", url = "http://localhost:4042")
//public interface DeliveryClient {
//    @GetMapping("/delivery/{orderId}/with-orders")
//    List<Delivery> getDeliveriesByOrderId(@RequestParam("orderId") Long orderId);
//}

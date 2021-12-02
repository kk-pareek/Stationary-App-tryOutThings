package com.tavant.stationary_shop.order.controller;

import com.tavant.stationary_shop.order.model.Order;
import com.tavant.stationary_shop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> applicationStatus(){
        return new ResponseEntity<>("order application is up", HttpStatus.OK);
    }

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer orderId){
        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.FOUND);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Order> updateOrderById(@PathVariable("id") Integer orderId, @RequestBody Order order){
        return new ResponseEntity<>(orderService.updateOrderById(orderId, order), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Order> deleteOrderById(@PathVariable("id") Integer orderId){
        return new ResponseEntity<>(orderService.deleteOrderById(orderId), HttpStatus.OK);
    }
}

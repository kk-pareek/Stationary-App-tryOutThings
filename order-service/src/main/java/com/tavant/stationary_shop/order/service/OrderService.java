package com.tavant.stationary_shop.order.service;

import com.tavant.stationary_shop.order.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order getOrderById(Integer orderId);
    Order updateOrderById(Integer orderId, Order order);
    Order deleteOrderById(Integer orderId);
}

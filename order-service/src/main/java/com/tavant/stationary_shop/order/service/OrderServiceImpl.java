package com.tavant.stationary_shop.order.service;

import com.tavant.stationary_shop.order.exception.OrderNotFoundException;
import com.tavant.stationary_shop.order.model.Order;
import com.tavant.stationary_shop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()){
            return order.get();
        }
        else {
            throw new OrderNotFoundException("order with given id:"+orderId+" not found");
        }
    }

    @Override
    public Order updateOrderById(Integer orderId, Order order) {
//        Order existingOrder = getOrderById(orderId);
//
//        existingOrder.setCustomerId(order.getCustomerId());
//        existingOrder.setProductId(order.getProductId());
//        existingOrder.setProductQty(order.getProductQty());
//        existingOrder.setProductPrice(order.getProductPrice());
//
//        return orderRepository.save(existingOrder);
        return null;
    }

    @Override
    public Order deleteOrderById(Integer orderId) {
        Order order = getOrderById(orderId);
        orderRepository.delete(order);
        return order;
    }
}

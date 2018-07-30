package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.OrderRepository;
import com.wolverineteam.onlinemarket.models.Order;
import com.wolverineteam.onlinemarket.services.base.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(int id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public void update(int id, Order order) {
        orderRepository.update(id, order);
    }

    @Override
    public void create(Order order) {
        orderRepository.create(order);
    }

    @Override
    public void delete(int id) {
        orderRepository.delete(id);
    }
}

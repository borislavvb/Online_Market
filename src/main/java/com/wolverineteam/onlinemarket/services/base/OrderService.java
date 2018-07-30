package com.wolverineteam.onlinemarket.services.base;

import com.wolverineteam.onlinemarket.models.Order;

import java.util.List;

public interface OrderService {

    Order getById(int id);

    List<Order> getAll();

    void update(int id, Order product);

    void create(Order product);

    void delete(int id);
}

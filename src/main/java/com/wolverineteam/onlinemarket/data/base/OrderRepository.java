package com.wolverineteam.onlinemarket.data.base;

import com.wolverineteam.onlinemarket.models.Order;

import java.util.List;

public interface OrderRepository {

    Order getById(int id);

    List<Order> getAll();

    void update(int id, Order order);

    void create(Order order);

    void delete(int id);
}

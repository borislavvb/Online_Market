package com.wolverineteam.onlinemarket.data.base;

import com.wolverineteam.onlinemarket.models.Order;

import java.util.List;

public interface OrderRepository {

    Order getById(int id);

    List<Order> getAll();

    void update(int id, Order product);

    void create(Order product);

    void delete(int id);
}

package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.OrderRepository;
import com.wolverineteam.onlinemarket.models.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public void update(int id, Order product) {

    }

    @Override
    public void create(Order product) {

    }

    @Override
    public void delete(int id) {

    }
}

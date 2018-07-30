package com.wolverineteam.onlinemarket.data.base;

import com.wolverineteam.onlinemarket.models.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer getById(int id);

    List<Customer> getAll();

    void update(int id, Customer product);

    void create(Customer product);

    void delete(int id);
}

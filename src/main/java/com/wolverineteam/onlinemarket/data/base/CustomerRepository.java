package com.wolverineteam.onlinemarket.data.base;

import com.wolverineteam.onlinemarket.models.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer getById(int id);

    List<Customer> getAll();

    void update(int id, Customer customer);

    void create(Customer customer);

    void delete(int id);
}

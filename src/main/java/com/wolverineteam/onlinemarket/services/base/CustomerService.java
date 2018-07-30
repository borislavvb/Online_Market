package com.wolverineteam.onlinemarket.services.base;

import com.wolverineteam.onlinemarket.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(int id);

    List<Customer> getAll();

    void update(int id, Customer customer);

    void create(Customer customer);

    void delete(int id);
}

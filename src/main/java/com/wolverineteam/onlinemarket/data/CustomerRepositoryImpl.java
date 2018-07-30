package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.CustomerRepository;
import com.wolverineteam.onlinemarket.models.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void update(int id, Customer product) {

    }

    @Override
    public void create(Customer product) {

    }

    @Override
    public void delete(int id) {

    }
}

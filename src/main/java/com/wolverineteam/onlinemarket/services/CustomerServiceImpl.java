package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.CustomerRepository;
import com.wolverineteam.onlinemarket.models.Customer;
import com.wolverineteam.onlinemarket.services.base.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepository.update(id, customer);
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }
}

package com.wolverineteam.onlinemarket.web;

import com.wolverineteam.onlinemarket.models.Customer;
import com.wolverineteam.onlinemarket.services.base.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        return customerService.getById(id);
    }

    @GetMapping("/")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String strId, @RequestBody Customer customer) {
        int id = Integer.parseInt(strId);
        customerService.update(id, customer);
    }

    @PostMapping("/create")
    public void create(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        customerService.delete(id);
    }
}

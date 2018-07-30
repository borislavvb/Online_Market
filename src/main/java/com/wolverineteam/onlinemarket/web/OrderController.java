package com.wolverineteam.onlinemarket.web;

import com.wolverineteam.onlinemarket.models.Order;
import com.wolverineteam.onlinemarket.services.base.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        return orderService.getById(id);
    }

    @GetMapping("/")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String strId, @RequestBody Order order) {
        int id = Integer.parseInt(strId);
        orderService.update(id, order);
    }

    @PostMapping("/create")
    public void create(@RequestBody Order order) {
        orderService.create(order);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        orderService.delete(id);
    }
}

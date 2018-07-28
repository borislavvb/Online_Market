package com.wolverineteam.onlinemarket.services.base;

import com.wolverineteam.onlinemarket.models.Product;

import java.util.List;

public interface ProductService {

    Product getById(int id);

    List<Product> getAll();

    void update(int id, Product product);

    void create(Product product);

    void delete(int id);
}

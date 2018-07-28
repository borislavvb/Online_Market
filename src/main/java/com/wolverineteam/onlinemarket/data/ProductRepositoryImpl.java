package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.ProductRepository;
import com.wolverineteam.onlinemarket.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void create(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}

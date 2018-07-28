package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.ProductRepository;
import com.wolverineteam.onlinemarket.models.Product;
import com.wolverineteam.onlinemarket.services.base.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }
}

package com.wolverineteam.onlinemarket.web;

import com.wolverineteam.onlinemarket.models.Product;
import com.wolverineteam.onlinemarket.services.base.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        return productService.getById(id);
    }

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.getAll();
    }

    public void update(String strId, Product product) {
        int id = Integer.parseInt(strId);
        productService.update(id, product);
    }

    public void create(Product product) {
        productService.create(product);
    }

    public void delete(String strId) {
        int id = Integer.parseInt(strId);
        productService.delete(id);
    }
}

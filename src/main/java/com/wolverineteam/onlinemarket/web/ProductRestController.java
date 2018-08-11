package com.wolverineteam.onlinemarket.web;

import com.wolverineteam.onlinemarket.models.Product;
import com.wolverineteam.onlinemarket.services.base.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
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

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String strId, @RequestBody Product product) {
        int id = Integer.parseInt(strId);
        productService.update(id, product);
    }

    @PostMapping("/create")
    public void create(@RequestBody Product product) {
        productService.create(product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        productService.delete(id);
    }
}

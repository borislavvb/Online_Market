package com.wolverineteam.onlinemarket.web;


import com.wolverineteam.onlinemarket.models.Brand;
import com.wolverineteam.onlinemarket.models.Product;
import com.wolverineteam.onlinemarket.services.BrandServiceImpl;
import com.wolverineteam.onlinemarket.services.base.BrandService;
import com.wolverineteam.onlinemarket.services.base.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
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
    public String getAll(Model model) {
        List<Product> products = productService.getAll();
        model.addAttribute("allProducts", products);
        return "products";
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String strId, @RequestBody Product product) {
        int id = Integer.parseInt(strId);
        productService.update(id, product);
    }

    @GetMapping("/add")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        productService.create(product);
        return "addProduct";
    }

    @PostMapping("/add")
    public String create(@ModelAttribute Product product) {
        productService.create(product);
        return "products";
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        productService.delete(id);
    }
}

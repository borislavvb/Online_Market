package com.wolverineteam.onlinemarket.web;

import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.services.base.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        return categoryService.getById(id);
    }

    @GetMapping("/")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String strId, @RequestBody Category category) {
        int id = Integer.parseInt(strId);
        categoryService.update(id, category);
    }

    @PostMapping("/create")
    public void create(@RequestBody Category category) {
        categoryService.create(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String strId) {
        int id = Integer.parseInt(strId);
        categoryService.delete(id);
    }
}

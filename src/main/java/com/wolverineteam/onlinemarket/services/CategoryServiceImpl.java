package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.CategoryRepository;
import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.services.base.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.getById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public void update(int id, Category category) {
        categoryRepository.update(id, category);
    }

    @Override
    public void create(Category category) {
        categoryRepository.create(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
}

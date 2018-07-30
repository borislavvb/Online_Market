package com.wolverineteam.onlinemarket.services.base;

import com.wolverineteam.onlinemarket.models.Category;

import java.util.List;

public interface CategoryService {

    Category getById(int id);

    List<Category> getAll();

    void update(int id, Category category);

    void create(Category category);

    void delete(int id);
}

package com.wolverineteam.onlinemarket.services.base;

import com.wolverineteam.onlinemarket.models.Category;

import java.util.List;

public interface CategoryService {

    Category getById(int id);

    List<Category> getAll();

    void update(int id, Category product);

    void create(Category product);

    void delete(int id);
}

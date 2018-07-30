package com.wolverineteam.onlinemarket.data.base;

import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.models.Product;

import java.util.List;

public interface CategoryRepository {

    Category getById(int id);

    List<Category> getAll();

    List<Product> getAllCategoryProducts(int id);

    void update(int id, Category category);

    void create(Category category);

    void delete(int id);
}

package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.CategoryRepository;
import com.wolverineteam.onlinemarket.models.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Category getById(int id) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public void update(int id, Category product) {

    }

    @Override
    public void create(Category product) {

    }

    @Override
    public void delete(int id) {

    }
}

package com.wolverineteam.onlinemarket.data.base;

import com.wolverineteam.onlinemarket.models.Brand;

import java.util.List;

public interface BrandRepository {
    Brand getById(int id);

    List<Brand> getAll();

    void update(int id, Brand brand);

    void create(Brand brand);

    void delete(int id);
}

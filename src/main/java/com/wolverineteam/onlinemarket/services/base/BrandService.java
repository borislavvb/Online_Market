package com.wolverineteam.onlinemarket.services.base;

import com.wolverineteam.onlinemarket.models.Brand;

import java.util.List;

public interface BrandService {

    Brand getById(int id);

    List<Brand> getAll();

    void update(int id, Brand product);

    void create(Brand product);

    void delete(int id);
}

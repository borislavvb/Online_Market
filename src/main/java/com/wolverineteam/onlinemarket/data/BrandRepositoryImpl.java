package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.models.Brand;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandRepositoryImpl implements BrandRepository {

    @Override
    public Brand getById(int id) {
        return null;
    }

    @Override
    public List<Brand> getAll() {
        return null;
    }

    @Override
    public void update(int id, Brand product) {

    }

    @Override
    public void create(Brand product) {

    }

    @Override
    public void delete(int id) {

    }
}

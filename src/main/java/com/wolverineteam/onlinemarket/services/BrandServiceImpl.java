package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.models.Brand;
import com.wolverineteam.onlinemarket.services.base.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.getById(id);
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }

    @Override
    public void update(int id, Brand brand) {
        brandRepository.update(id, brand);
    }

    @Override
    public void create(Brand brand) {
        brandRepository.create(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.delete(id);
    }
}

package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.OrderRepository;
import com.wolverineteam.onlinemarket.data.base.ProductRepository;
import com.wolverineteam.onlinemarket.models.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {
    @Mock
    ProductRepository mockRepository;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    public void GetById_Returns_ProductWithSameId(){

    }

    @Test
    public void GetAll_Returns_AllProducts(){

    }

    @Test
    public void UpdateProduct_Returns_UpdatedProduct(){

    }

    @Test
    public void CreateProduct_Returns_NewProduct(){

    }

    @Test
    public void DeleteProduct_Returns_TheProductHasBeenDeleted(){

    }
}

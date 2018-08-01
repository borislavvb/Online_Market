package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.OrderRepository;
import com.wolverineteam.onlinemarket.data.base.ProductRepository;
import com.wolverineteam.onlinemarket.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTests {

    DataSource source;

    @Mock
    ProductRepository mockRepository;

    @InjectMocks
    ProductServiceImpl service;

    @Test
    public void GetById_Returns_ProductWithSameId(){
        Mockito.when(mockRepository.getById(1))
                .thenReturn(new Product(mock(Brand.class),"TestModel",mock(Category.class),"Test Description",2));

        Product result = service.getById(1);

        Assert.assertEquals("TestModel",result.getModel());
    }

    @Test
    public void GetAll_Returns_AllProducts(){
        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Product(mock(Brand.class),"TestMode2",mock(Category.class),"Test Description3",1),
                        new Product(mock(Brand.class),"TestModel",mock(Category.class),"Test Description4",4),
                        new Product(mock(Brand.class),"TestMode3",mock(Category.class),"Test Description2",3),
                        new Product(mock(Brand.class),"TestMode4",mock(Category.class),"Test Description1",2)
                ));

        List<Product> result = service.getAll();

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void UpdateProduct_Returns_UpdatedProduct(){
        Product mockProduct1 = new Product(mock(Brand.class),"TestMode2",mock(Category.class),"Test Description3",1);
        Product mockProduct2 = new Product(mock(Brand.class),"TestMode3",mock(Category.class),"Test Description2",3);

        doNothing().when(mockRepository).update(isA(Integer.class),isA(Product.class));
        service.update(1,mockProduct2);

        verify(mockRepository,times(1)).update(1,mockProduct2);
    }

    @Test
    public void CreateProduct_Returns_NewProduct(){
        Product mockProduct = new Product(mock(Brand.class),"TestMode4",mock(Category.class),"Test Description1",2);
        doNothing().when(mockRepository).create(isA(Product.class));
        service.create(mockProduct);

        verify(mockRepository,times(1)).create(mockProduct);
    }

    @Test
    public void DeleteProduct_Returns_TheProductHasBeenDeleted(){
        Product mockProduct = new Product(mock(Brand.class),"TestModel",mock(Category.class),"Test Description4",4);
        doNothing().when(mockRepository).delete(isA(Integer.class));
        service.delete(1);

        verify(mockRepository,times(1)).delete(1);
    }
}

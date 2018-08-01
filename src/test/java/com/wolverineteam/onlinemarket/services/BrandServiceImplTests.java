package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.models.Brand;
import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceImplTests {
    @Mock
    BrandRepository mockRepository;

    @InjectMocks
    BrandServiceImpl service;

    @Test
    public void GetById_Return_BrandWithSameId(){

        when(mockRepository.getById(1))
                .thenReturn(new Brand("TestBrand1"));

        Brand result = service.getById(1);

        Assert.assertEquals("TestBrand1",result.getBrandName());
    }

    @Test
    public void GetAll_Return_AllBrands(){

        when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Brand("TestBrand1"),
                        new Brand("TestBrand2"),
                        new Brand("TestBrand3"),
                        new Brand("TestBrand4")
                ));

        List<Brand> result = service.getAll();

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void GetAllBrandProducts_Returns_AllBrandProducts(){
        Brand mockBrand = mock(Brand.class);

        when(mockRepository.getAllBrandProducts(1))
                .thenReturn(Arrays.asList(
                        new Product(mockBrand,"TestModel2",new Category("TestModel2"),"Test2",2),
                        new Product(mockBrand,"TestModel1",new Category("TestCategory1"),"Test",1)));


        List<Product> result = service.getAllBrandProducts(1);

        Assert.assertEquals(2,result.size());
    }

    @Test
    public void UpdateBrand_Returns_UpdatedBrand(){
        Brand mockBrand1 = new Brand("MockBrand1");
        Brand mockBrand2 = new Brand("MockBrand2");

        doNothing().when(mockRepository).update(isA(Integer.class),isA(Brand.class));
        service.update(1,mockBrand2);

        verify(mockRepository,times(1)).update(1,mockBrand2);
    }



    @Test
    public void CreateBrand_Returns_NewBrand(){
        Brand brand = new Brand("Test");
        doNothing().when(mockRepository).create(isA(Brand.class));
        service.create(brand);

        verify(mockRepository,times(1)).create(brand);
    }

    @Test
    public void DeleteBrand_Return_TheBrandHasBeenDeleted(){
        Brand brand = new Brand("Test");
        doNothing().when(mockRepository).delete(isA(Integer.class));
        service.delete(1);

        verify(mockRepository,times(1)).delete(1);
    }
}

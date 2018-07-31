package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.models.Brand;
import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.models.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BrandServiceImplTests {
    @Mock
    BrandRepository mockRepository;

    @InjectMocks
    BrandServiceImpl service;

    @Test
    public void GetById_Return_BrandWithSameId(){

        Mockito.when(mockRepository.getById(1))
                .thenReturn(new Brand("TestBrand1"));

        Brand result = service.getById(1);

        Assert.assertEquals("TestBrand1",result.getBrandName());
    }

    @Test
    public void GetAll_Return_AllBrands(){

        Mockito.when(mockRepository.getAll())
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

        Mockito.when(mockRepository.getAllBrandProducts(1))
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

        mockRepository.update(1,mockBrand2);

        Assert.assertEquals(mockBrand2.getBrandName(),mockBrand1.getBrandName());
    }

    @Test
    public void CreateBrand_Returns_NewBrand(){
        Brand mockBrand = new Brand();
        try {
            mockBrand.setBrandName("MockBrand");
            mockRepository.create(mockBrand);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void DeleteBrand_Return_TheBrandHasBeenDeleted(){
        try{
            mockRepository.delete(1);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}

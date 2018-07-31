package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.data.base.CategoryRepository;
import com.wolverineteam.onlinemarket.models.Brand;
import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.models.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTests {
    @Mock
    CategoryRepository mockRepository;

    @InjectMocks
    CategoryServiceImpl service;

    @Test
    public void GetById_Return_CategoryWithSameId(){

        Mockito.when(mockRepository.getById(1))
                .thenReturn(new Category("TestCategory1"));

        Category result = service.getById(1);

        Assert.assertEquals("TestCategory1",result.getCategoryName());
    }

    @Test
    public void GetAll_Return_AllCategories(){

        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Category("TestCategory1"),
                        new Category("TestCategory2"),
                        new Category("TestCategory3"),
                        new Category("TestCategory4")
                ));

        List<Category> result = service.getAll();

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void GetAllCategoryProducts_Returns_AllCategoryProducts(){
        Category mockCategory = mock(Category.class);

        Mockito.when(mockRepository.getAllCategoryProducts(1))
                .thenReturn(Arrays.asList(
                        new Product(mock(Brand.class),"TestModel2",mockCategory,"Test2",2),
                        new Product(mock(Brand.class),"TestModel1",mockCategory,"Test",1)));


        List<Product> result = service.getAllCategoryProducts(1);

        Assert.assertEquals(2,result.size());
    }

    @Test
    public void UpdateCategory_Returns_UpdatedCategory(){
        Category mockCategory1 = new Category("MockCategory1");
        Category mockCategory2 = new Category("MockCategory2");

        mockRepository.update(1,mockCategory2);

        Assert.assertEquals(mockCategory2.getCategoryName(),mockCategory1.getCategoryName());
    }

    @Test
    public void CreateCategory_Returns_NewCategory(){
        Category mockCategory = new Category();
        try {
            mockCategory.setCategoryName("MockBrand");
            mockRepository.create(mockCategory);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void DeleteCategory_Return_TheCategoryHasBeenDeleted(){
        try{
            mockRepository.delete(1);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}

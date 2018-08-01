package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.CategoryRepository;
import com.wolverineteam.onlinemarket.models.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceImplTests {
    @Mock
    private CategoryRepository mockRepository;

    @InjectMocks
    private CategoryServiceImpl service;

    @Before
    public void beforeTest(){
               service = new CategoryServiceImpl(mockRepository);
    }

    @Test
    public void GetById_Return_CategoryWithSameId(){

        when(mockRepository.getById(1))
                .thenReturn(new Category("TestCategory1"));

        Category result = service.getById(1);

        Assert.assertEquals("TestCategory1",result.getCategoryName());
    }

    @Test
    public void GetAll_Return_AllCategories(){

        when(mockRepository.getAll())
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

        when(mockRepository.getAllCategoryProducts(1))
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

        doNothing().when(mockRepository).update(isA(Integer.class),isA(Category.class));
        service.update(1,mockCategory2);

        verify(mockRepository,times(1)).update(1,mockCategory2);
    }

    @Test
    public void CreateCategory_Returns_NewCategory(){
        Category category = new Category("Test");
        doNothing().when(mockRepository).create(isA(Category.class));
        service.create(category);

        verify(mockRepository,times(1)).create(category);
    }

    @Test
    public void DeleteCategory_Return_TheCategoryHasBeenDeleted(){
        Category category = new Category("Test");
        doNothing().when(mockRepository).delete(isA(Integer.class));
        service.delete(1);

        verify(mockRepository,times(1)).delete(1);
    }
}

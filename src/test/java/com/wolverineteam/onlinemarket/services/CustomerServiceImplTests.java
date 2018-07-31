package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.data.base.CustomerRepository;
import com.wolverineteam.onlinemarket.models.Category;
import com.wolverineteam.onlinemarket.models.Customer;
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
public class CustomerServiceImplTests {
    @Mock
    CustomerRepository mockRepository;

    @InjectMocks
    CustomerServiceImpl service;

    @Test
    public void GetById_Return_CustomerWithSameId(){

        Mockito.when(mockRepository.getById(1))
                .thenReturn(new Customer("MockCustomer","MockPass"));

        Customer result = service.getById(1);

        Assert.assertEquals("MockCustomer",result.getUsername());
    }

    @Test
    public void GetAll_Return_AllCustomers(){

        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Customer("MockCustomer1","MockPass1"),
                        new Customer("MockCustomer2","MockPass2"),
                        new Customer("MockCustomer2","MockPass2"),
                        new Customer("MockCustomer2","MockPass2")
                ));

        List<Customer> result = service.getAll();

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void UpdateCustomer_Returns_UpdatedCustomer(){
        Customer mockCustomer1 = new Customer("MockCustomer1","MockPass");
        Customer mockCustomer2 = new Customer("MockCustomer2","MockPass");

        mockRepository.update(1,mockCustomer2);

        Assert.assertEquals(mockCustomer2.getUsername(),mockCustomer1.getUsername());
    }

    @Test
    public void CreateCustomer_Returns_NewCustomer(){
        Customer mockCustomer = new Customer();
        try {
            mockCustomer.setUsername("MockCustomer");
            mockRepository.create(mockCustomer);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void DeleteCustomer_Return_TheCustomerHasBeenDeleted(){
        try{
            mockRepository.delete(1);
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}

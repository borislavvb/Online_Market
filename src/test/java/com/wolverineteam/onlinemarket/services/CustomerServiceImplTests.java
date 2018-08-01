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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

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

        doNothing().when(mockRepository).update(isA(Integer.class),isA(Customer.class));
        service.update(1,mockCustomer2);

        verify(mockRepository,times(1)).update(1,mockCustomer2);
    }

    @Test
    public void CreateCustomer_Returns_NewCustomer(){
        Customer mockCustomer = new Customer("MockUsername","MockPass");
        doNothing().when(mockRepository).create(isA(Customer.class));
        service.create(mockCustomer);

        verify(mockRepository,times(1)).create(mockCustomer);
    }

    @Test
    public void DeleteCustomer_Return_TheCustomerHasBeenDeleted(){
        Customer customer = new Customer("TestUsername","TestPass");
        doNothing().when(mockRepository).delete(isA(Integer.class));
        service.delete(1);

        verify(mockRepository,times(1)).delete(1);
    }

}

package com.wolverineteam.onlinemarket.services;

import com.wolverineteam.onlinemarket.data.base.CustomerRepository;
import com.wolverineteam.onlinemarket.data.base.OrderRepository;
import com.wolverineteam.onlinemarket.models.Customer;
import com.wolverineteam.onlinemarket.models.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.spi.DateFormatProvider;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTests {
    @Mock
    OrderRepository mockRepository;

    @InjectMocks
    OrderServiceImpl service;

    @Test
    public void GetById_Return_OrderWithSameId(){
        Mockito.when(mockRepository.getById(1))
                .thenReturn(new Order(new Customer("TestUsername1","TestPass1")));

        Order result = service.getById(1);

        Assert.assertEquals("TestUsername1",result.getCustomerId().getUsername());
    }

    @Test
    public void GetAll_Return_AllOrders(){
        Mockito.when(mockRepository.getAll())
                .thenReturn(Arrays.asList(
                        new Order(new Customer("TestUsername1","TestPass1")),
                        new Order(new Customer("TestUsername2","TestPass2")),
                        new Order(new Customer("TestUsername3","TestPass3")),
                        new Order(new Customer("TestUsername4","TestPass4"))
                ));

        List<Order> result = service.getAll();

        Assert.assertEquals(4,result.size());
    }

    @Test
    public void UpdateOrder_Returns_UpdatedOrder(){
        Order mockOrder1 = new Order(new Customer("MockCustomer1","MockPass"));
        Order mockOrder2 = new Order(new Customer("MockCustomer2","MockPass"));

        doNothing().when(mockRepository).update(isA(Integer.class),isA(Order.class));
        service.update(1,mockOrder2);

        verify(mockRepository,times(1)).update(1,mockOrder2);
    }

    @Test
    public void CreateOrder_Returns_NewOrder(){
        Order mockOrder = new Order(new Customer("MockUsername","MockPass"));
        doNothing().when(mockRepository).create(isA(Order.class));
        service.create(mockOrder);

        verify(mockRepository,times(1)).create(mockOrder);
    }

    @Test
    public void DeleteOrder_Return_TheOrderHasBeenDeleted(){
        Order mockOrder = new Order(new Customer("TestUsername","TestPass"));
        doNothing().when(mockRepository).delete(isA(Integer.class));
        service.delete(1);

        verify(mockRepository,times(1)).delete(1);
    }
}

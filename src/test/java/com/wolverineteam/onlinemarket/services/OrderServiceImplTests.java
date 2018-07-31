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

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTests {
    @Mock
    OrderRepository mockRepository;

    @InjectMocks
    OrderServiceImpl service;

    @Test
    public void GetById_Return_OrderWithSameId(){

    }

    @Test
    public void GetAll_Return_AllOrders(){

    }

    @Test
    public void UpdateOrder_Returns_UpdatedOrder(){

    }

    @Test
    public void CreateOrder_Returns_NewOrder(){

    }

    @Test
    public void DeleteOrder_Return_TheOrderHasBeenDeleted(){

    }
}

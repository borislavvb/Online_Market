package com.wolverineteam.onlinemarket.config;

import com.wolverineteam.onlinemarket.models.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public SessionFactory createSessionFactory() {
        System.out.println("SessionFactory was created.");
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Brand.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }
}

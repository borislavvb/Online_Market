package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.CustomerRepository;
import com.wolverineteam.onlinemarket.models.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private SessionFactory sessionFactory;

    public CustomerRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer getById(int id) {
        Customer customer = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            customer = session.get(Customer.class, id);
            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customer = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            customer = session.createQuery("from Customer", Customer.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public void update(int id, Customer customer) {

    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }
}

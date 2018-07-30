package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.OrderRepository;
import com.wolverineteam.onlinemarket.models.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private SessionFactory sessionFactory;

    public OrderRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order getById(int id) {
        Order order = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            order = session.get(Order.class, id);
            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> order = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            order = session.createQuery("from Order", Order.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order;
    }

    @Override
    public void update(int id, Order product) {

    }

    @Override
    public void create(Order product) {

    }

    @Override
    public void delete(int id) {

    }
}

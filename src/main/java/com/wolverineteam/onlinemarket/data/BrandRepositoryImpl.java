package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.BrandRepository;
import com.wolverineteam.onlinemarket.models.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BrandRepositoryImpl implements BrandRepository {

    private SessionFactory sessionFactory;

    public BrandRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Brand getById(int id) {
        Brand brand = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            brand = session.get(Brand.class, id);
            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return brand;
    }

    @Override
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            brands = session.createQuery("from Brand", Brand.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return brands;
    }

    @Override
    public void update(int id, Brand product) {

    }

    @Override
    public void create(Brand product) {

    }

    @Override
    public void delete(int id) {

    }
}

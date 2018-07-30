package com.wolverineteam.onlinemarket.data;

import com.wolverineteam.onlinemarket.data.base.CategoryRepository;
import com.wolverineteam.onlinemarket.models.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private SessionFactory sessionFactory;

    public CategoryRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Category getById(int id) {
        Category category = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            category = session.get(Category.class, id);
            session.getTransaction().commit();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return category;
    }

    @Override
    public List<Category> getAll() {
        List<Category> category = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            category = session.createQuery("from Category", Category.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    @Override
    public void update(int id, Category category) {

    }

    @Override
    public void create(Category category) {

    }

    @Override
    public void delete(int id) {

    }
}

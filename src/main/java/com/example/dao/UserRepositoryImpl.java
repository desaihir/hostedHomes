// UserRepositoryImpl.java
package com.example.dao;

import com.example.config.HibernateConfig;
import com.example.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

//    @Autowired
    private SessionFactory sessionFactory = HibernateConfig.SessionFactory();

    @Override
    public User findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                          .setParameter("username", username)
                          .uniqueResult();
        }
    }

    @Override
    public User findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User WHERE email = :email", User.class)
                          .setParameter("email", email)
                          .uniqueResult();
        }
    }

    @Override
    public User findByUsernameOrEmail(String username, String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User WHERE username = :username OR email = :email", User.class)
                          .setParameter("username", username)
                          .setParameter("email", email)
                          .uniqueResult();
        }
    }

    @Override
    public boolean existsByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            Long count = session.createQuery("SELECT COUNT(*) FROM User WHERE username = :username", Long.class)
                                .setParameter("username", username)
                                .uniqueResult();
            return count != null && count > 0;
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Long count = session.createQuery("SELECT COUNT(*) FROM User WHERE email = :email", Long.class)
                                .setParameter("email", email)
                                .uniqueResult();
            return count != null && count > 0;
        }
    }

    @Override
    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

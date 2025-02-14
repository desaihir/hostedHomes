package com.example.dao;

import com.example.config.HibernateConfig;
import com.example.pojo.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

//    @Autowired
	private SessionFactory sessionFactory = HibernateConfig.SessionFactory();

    @Override
    public List<Image> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Image", Image.class).getResultList();
        }
    }

    @Override
    public List<Image> findByIsPrimary(boolean isPrimary) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Image WHERE isPrimary = :isPrimary", Image.class)
                          .setParameter("isPrimary", isPrimary)
                          .getResultList();
        }
    }

    @Override
    public List<Image> findByListingId(Long listingId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Image WHERE listing.id = :listingId", Image.class)
                          .setParameter("listingId", listingId)
                          .getResultList();
        }
    }
    
    @Override
    public Image findPrimaryByListingId(Long listingId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Image WHERE listing.id = :listingId AND isPrimary = true", Image.class)
                          .setParameter("listingId", listingId)
                          .uniqueResult();
        }
    }
}

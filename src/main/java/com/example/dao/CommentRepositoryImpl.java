// CommentRepositoryImpl.java
package com.example.dao;

import com.example.config.HibernateConfig;
import com.example.dao.CommentRepository;
import com.example.pojo.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

//    @Autowired
	private SessionFactory sessionFactory = HibernateConfig.SessionFactory();

    @Override
    public void save(Comment comment, String username) {
        try (Session session = sessionFactory.openSession()) {
        	System.out.println("---------------------------------------");
        	System.out.println("Entered save function in CommentRepoImpl !!");
        	System.out.println("---------------------------------------");
        	System.out.println("Comment : "+ comment.getComment());
        	System.out.println("---------------------------------------");
        	System.out.println("Username : "+ username);
        	System.out.println("---------------------------------------");
            session.beginTransaction();
            session.save(comment);
            comment.setUsername(username);
         // Convert LocalDateTime to Date
            LocalDateTime currentDateTime = LocalDateTime.now();
            Date currentDate = Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());

            // Set created_at
            comment.setCreatedAt(currentDate);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Comment findById(Long commentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Comment.class, commentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteById(Long commentId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Comment comment = session.get(Comment.class, commentId);
            if (comment != null) {
                session.delete(comment);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Comment> findByListingId(Long listingId) {
        try (Session session = sessionFactory.openSession()) {      
        	System.out.println("---------------------------------------");
        	System.out.println("Entered findByListingId function in CommentRepoImpl !!");
        	System.out.println("---------------------------------------");
            return session.createQuery("FROM Comment WHERE listingId = :listingId", Comment.class)
                    .setParameter("listingId", listingId)
                    .getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

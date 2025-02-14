// ListingRepositoryImpl.java
package com.example.dao;

import com.example.config.HibernateConfig;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListingRepositoryImpl implements ListingRepository {

    
    private SessionFactory sessionFactory = HibernateConfig.SessionFactory();

    @Override
    public List<Listing> findAll(int page, int pageSize) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Listing", Listing.class)
                          .setFirstResult(page * pageSize)
                          .setMaxResults(pageSize)
                          .getResultList();
        }
    }

    @Override
    public int getTotalListings() {
        try (Session session = sessionFactory.openSession()) {
            Long count = (Long) session.createQuery("SELECT COUNT(*) FROM Listing").uniqueResult();
            return count != null ? count.intValue() : 0;
        }
    }
    
//    @Override
    public Listing getListingById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Listing.class, id);
        }
    }
    
    @Override
    public List<Listing> findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Listing WHERE username = :username", Listing.class)
                          .setParameter("username", username)
                          .getResultList();
        }
    }
    
    @Override
    public List<Listing> findByLocation(String location) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Listing WHERE location = :location", Listing.class)
                          .setParameter("location", location)
                          .getResultList();
        }
    }

	@Override
	public Listing findById(Long id) {
		try (Session session = sessionFactory.openSession()) {
	        return session.get(Listing.class, id);
	    } catch (HibernateException e) {
	        // Handle exceptions or log them if necessary
	        e.printStackTrace();
	        return null; 
	    }
	}		
	
	@Override
    public void save(Listing listing, String username) {
        try (Session session = sessionFactory.openSession()) {
        	System.out.println("---------------------------------------");
        	System.out.println("Username in update in ListingRepoImpl : "+ username);
        	System.out.println("---------------------------------------");
            session.beginTransaction();
            session.save(listing); 
            listing.setUsername(username);// Use save method for new listings
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Listing listing, String username) {
        try (Session session = sessionFactory.openSession()) {
        	System.out.println("---------------------------------------");
        	System.out.println("Entered update in ListingRepoImpl !!");
        	System.out.println("---------------------------------------");
        	System.out.println("Username in update in ListingRepoImpl : "+ username);
        	System.out.println("---------------------------------------");
            session.beginTransaction();
            session.update(listing); 
            listing.setUsername(username);// Use update method for existing listings
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public void updateListing(Listing listing) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            System.out.println("---------------------------------------");
        	System.out.println("Entered updateListing in ListingRepoImpl !!");
        	System.out.println("---------------------------------------");
            
            // Retrieve the existing listing details associated with the listing being updated
            ListingDetails existingListingDetails = session.get(ListingDetails.class, listing.getId());
            
            // Update the fields of the existing listing details with the new values
            existingListingDetails.setLocation(listing.getLocation());
            // Update other fields as needed
            
            // Save or update the existing listing details
            session.saveOrUpdate(existingListingDetails);
            
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Listing listing = session.get(Listing.class, id);
            if (listing != null) {
                session.delete(listing);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//ListingDetailsRepositoryImpl.java
package com.example.dao;

import com.example.config.HibernateConfig;
import com.example.pojo.ListingDetails;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ListingDetailsRepositoryImpl implements ListingDetailsRepository {

//    @Autowired
	private SessionFactory sessionFactory = HibernateConfig.SessionFactory();

	@Override
	public List<ListingDetails> findAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createQuery("FROM ListingDetails", ListingDetails.class).getResultList();
		}
	}

	@Override
	public List<ListingDetails> findByListingId(Long listingId) {
		try (Session session = sessionFactory.openSession()) {
			Query<ListingDetails> query = session.createQuery("FROM ListingDetails WHERE listing_id = :listingId",
					ListingDetails.class);
			query.setParameter("listingId", listingId);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList(); // Return an empty list in case of an exception
		}
	}

	@Override
	public ListingDetails findById(Long id) {
		try (Session session = sessionFactory.openSession()) {
			return session.get(ListingDetails.class, id);
		}
	}
	
	@Override
	public List<ListingDetails> findByLocation(String location) {
		System.out.println("---------------------------------------");
    	System.out.println("ENTERED findByLocation!");        
    	System.out.println("---------------------------------------");
//		try (Session session = sessionFactory.openSession()) {
//			return session.get(ListingDetails.class, location);
//		}
    	try (Session session = sessionFactory.openSession()) {
			Query<ListingDetails> query = session.createQuery("FROM ListingDetails WHERE location = :location",
					ListingDetails.class);
			query.setParameter("location", location);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return Collections.emptyList(); // Return an empty list in case of an exception
		}			
	}
	
	public void save(ListingDetails listingDetails) {
		try (Session session = sessionFactory.openSession()) {
			System.out.println("---------------------------------------");
			System.out.println("Entered save in ListingDetails RepoImpl !!");
			System.out.println("---------------------------------------");
			session.beginTransaction();
			session.save(listingDetails);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(ListingDetails listingDetails, Long listingId) {
		try (Session session = sessionFactory.openSession()) {
			System.out.println("---------------------------------------");
			System.out.println("Entered update in ListingDetails RepoImpl !!");
			System.out.println("---------------------------------------");
			session.beginTransaction();
			if (listingDetails.getListingDetailsId() != null) {
				// Update existing listing details
				session.update(listingDetails);
				listingDetails.setListing(listingId);
			} else {
				// Save new listing details
				session.save(listingDetails);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById(Long id) {
		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();
			ListingDetails listingDetails = session.get(ListingDetails.class, id);
			if (listingDetails != null) {
				session.delete(listingDetails);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

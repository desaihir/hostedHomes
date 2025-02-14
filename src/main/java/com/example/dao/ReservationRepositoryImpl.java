//ReservationRepositoryImpl.java
package com.example.dao;

import com.example.config.HibernateConfig;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;
import com.example.pojo.Reservation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ReservationRepositoryImpl implements ReservationRepository {		

//    @Autowired
	private SessionFactory sessionFactory = HibernateConfig.SessionFactory();

    @Override
    public void save(Reservation reservation, String username, Long listingId, Date startDate, Date endDate) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            reservation.setUsername(username);
            reservation.setListingId(listingId);
            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);            
            session.save(reservation);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Reservation reservation, String username) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            reservation.setUsername(username);
            session.update(reservation);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long reservationId) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.delete(reservation);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            

    @Override
    public List<Reservation> findByUsername(String username) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Reservation WHERE username = :username", Reservation.class)
                    .setParameter("username", username)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> findByListingId(Long listingId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Reservation WHERE listingId = :listingId", Reservation.class)
                    .setParameter("listingId", listingId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public List<Date> findBookedDatesByListingId(Long listingId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT r.startDate FROM Reservation r WHERE r.listingId = :listingId", Date.class)
                    .setParameter("listingId", listingId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public Reservation findByReservationId(Long reservationId) {
		try (Session session = sessionFactory.openSession()) {
	        return session.get(Reservation.class, reservationId);
	    } catch (HibernateException e) {
	        e.printStackTrace();
	        return null; 
	    }
	}
}

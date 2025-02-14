package com.example.service;

import com.example.dao.ReservationRepository;
import com.example.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void addReservation(Reservation reservation, String username, Long listingId, Date startDate, Date endDate) {
        reservationRepository.save(reservation, username, listingId, startDate, endDate);
    }

    @Override
    public void updateReservation(Reservation reservation, String username) {
        reservationRepository.update(reservation, username);
    }

    @Override
    public void cancelReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getReservationsByUsername(String username) {
        return reservationRepository.findByUsername(username);
    }

    @Override
    public List<Reservation> getReservationsByListingId(Long listingId) {
        return reservationRepository.findByListingId(listingId);
    }
    
    @Override
    public List<Date> getBookedDatesByListingId(Long listingId) {
        return reservationRepository.findBookedDatesByListingId(listingId);
    }

	@Override
	public Reservation getReservationById(Long reservationId) {
		
		return reservationRepository.findByReservationId(reservationId);
	}
}

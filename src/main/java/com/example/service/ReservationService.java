package com.example.service;

import com.example.pojo.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationService {
	void addReservation(Reservation reservation, String username, Long listingId, Date startDate, Date endDate);
    void updateReservation(Reservation reservation, String username);
    void cancelReservation(Long reservationId);
    List<Reservation> getReservationsByUsername(String username);
    List<Reservation> getReservationsByListingId(Long listingId);
    List<Date> getBookedDatesByListingId(Long listingId);
	Reservation getReservationById(Long reservationId);    
}

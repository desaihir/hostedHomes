package com.example.dao;

import com.example.pojo.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationRepository {
    void save(Reservation reservation, String username, Long listingId, Date startDate, Date endDate);
    void update(Reservation reservation, String username);
    void deleteById(Long reservationId);
    List<Reservation> findByUsername(String username);
    List<Reservation> findByListingId(Long listingId);
    List<Date> findBookedDatesByListingId(Long listingId);
	Reservation findByReservationId(Long reservationId);
}

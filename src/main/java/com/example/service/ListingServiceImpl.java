// ListingServiceImpl.java
package com.example.service;

import com.example.dao.ListingRepository;
import com.example.pojo.Listing;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public List<Listing> getAllListings(int page, int pageSize) {
        return listingRepository.findAll(page, pageSize);
    }

    @Override
    public int getTotalPages(int pageSize) {
        int totalListings = listingRepository.getTotalListings();
        return (int) Math.ceil((double) totalListings / pageSize);
    }
    
    @Override
    public Listing getListingById(Long id) {
        return listingRepository.findById(id);
    }
    
    @Override
    public List<Listing> getListingsByUsername(String username) {
        return listingRepository.findByUsername(username);
    }
    
    @Override
    public List<Listing> getListingsByLocation(String location){
    	return listingRepository.findByLocation(location); 
    }
    
    @Override
    public void createListing(Listing listing, String username) {  	   	
//        listing.setUsername(username);
        listingRepository.save(listing, username);
    }
       

    @Override
    public void updateListing(Listing listing, String username) {
        listingRepository.update(listing, username); // Use update method for existing listings
    }

    @Override
    public void deleteListing(Long id) {
        listingRepository.deleteById(id);
    }

	
}

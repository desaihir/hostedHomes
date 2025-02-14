// ListingService.java
package com.example.service;

import com.example.pojo.Listing;

import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface ListingService {
    List<Listing> getAllListings(int page, int pageSize);
    Listing getListingById(Long id);
    List<Listing> getListingsByUsername(String username);
    List<Listing> getListingsByLocation(String location);
    int getTotalPages(int pageSize);
    void createListing(Listing listing, String username);
    void updateListing(Listing listing, String username);
    void deleteListing(Long id);
}

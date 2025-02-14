package com.example.dao;

import com.example.pojo.ListingDetails;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingDetailsRepository {
    List<ListingDetails> findAll();
    List<ListingDetails> findByListingId(Long listingId);
    ListingDetails findById(Long id);
    void update(ListingDetails listingDetails, Long listingId);
    void save(ListingDetails listingDetails);
    void deleteById(Long id);
    List<ListingDetails> findByLocation(String location);
    
}

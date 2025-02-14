// ListingRepository.java
package com.example.dao;

import com.example.pojo.Listing;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository {
    List<Listing> findAll(int page, int pageSize);
    Listing findById(Long id);
    List<Listing> findByUsername(String username);
    void save(Listing listing, String username);
    void update(Listing listing, String username);
    void deleteById(Long id);
    int getTotalListings();
	List<Listing> findByLocation(String location);    
}

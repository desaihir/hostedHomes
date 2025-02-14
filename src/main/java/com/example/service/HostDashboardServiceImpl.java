package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ListingDetailsRepository;
import com.example.dao.ListingRepository;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;


@Service
public class HostDashboardServiceImpl implements HostDashboardService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private ListingDetailsRepository listingDetailsRepository;

    @Override
    public List<Listing> getListingsByUsername(String username) {
        return listingRepository.findByUsername(username);
    }

    @Override
    public List<ListingDetails> getListingDetailsByListingId(Long listingId) {
        return listingDetailsRepository.findByListingId(listingId);
    }
    
}

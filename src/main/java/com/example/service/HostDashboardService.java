package com.example.service;

import java.util.List;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;

public interface HostDashboardService {
    List<Listing> getListingsByUsername(String username);
    List<ListingDetails> getListingDetailsByListingId(Long listingId);
}

//package com.example.service;
//
//import com.example.pojo.ListingDetails;
//
//import java.util.List;
//
//public interface ListingDetailsService {
//    List<ListingDetails> getAllListingDetails();
//    ListingDetails getListingDetailsById(Long id);
//    ListingDetails getListingDetailsByListingId(Long listingId);
//}

package com.example.service;

import com.example.pojo.ListingDetails;
import java.util.List;

import org.springframework.stereotype.Service;
//import org.springframework.stereotype.Service;

@Service
public interface ListingDetailsService {
    List<ListingDetails> getAllListingDetails();
    ListingDetails getListingDetailsById(Long id);
    void createListingDetails(ListingDetails listingDetails);
    void updateListingDetails(ListingDetails listingDetails, Long listingId);
    void deleteListingDetails(Long id);
    List<ListingDetails> getListingDetailsByLocation(String location);
}

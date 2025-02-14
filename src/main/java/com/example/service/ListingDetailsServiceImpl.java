//package com.example.service;
//
//import com.example.dao.ListingDetailsRepository;
//import com.example.pojo.ListingDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ListingDetailsServiceImpl implements ListingDetailsService {
//
//    @Autowired
//    private ListingDetailsRepository listingDetailsRepository;
//
//    @Override
//    public List<ListingDetails> getAllListingDetails() {
//        return listingDetailsRepository.findAll();
//    }
//
//    @Override
//    public ListingDetails getListingDetailsById(Long id) {
//        return listingDetailsRepository.findById(id);
//    }
//    
//    @Override
//    public ListingDetails getListingDetailsByListingId(Long listingId) {
//        return listingDetailsRepository.findByListingId(listingId);
//    }
//}

package com.example.service;

import com.example.dao.ListingDetailsRepository;
import com.example.pojo.ListingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListingDetailsServiceImpl implements ListingDetailsService {

    @Autowired
    private ListingDetailsRepository listingDetailsRepository;

    @Override
    public List<ListingDetails> getAllListingDetails() {
        return listingDetailsRepository.findAll();
    }

    @Override
    public ListingDetails getListingDetailsById(Long id) {
        return listingDetailsRepository.findById(id);
    }
    
    @Override
    public List<ListingDetails> getListingDetailsByLocation(String location) {
    	return listingDetailsRepository.findByLocation(location);
    }
    
    @Override
    public void createListingDetails(ListingDetails listingDetails) {
        listingDetailsRepository.save(listingDetails);
    }

    @Override
    public void updateListingDetails(ListingDetails listingDetails, Long listingId) {
        listingDetailsRepository.update(listingDetails, listingId);
    }

    @Override
    public void deleteListingDetails(Long id) {
        listingDetailsRepository.deleteById(id);
    }
}

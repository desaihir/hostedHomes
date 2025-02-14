package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.ListingDetails;
import com.example.service.ListingDetailsService;

@RestController
@RequestMapping("/api/listingdetails")
public class TestListingDetailsController {

    @Autowired
    private ListingDetailsService listingDetailsService;
    
    @GetMapping("/testListingDetails")
    public String getListingDetails(Model model) {
    	System.out.println("entered test Listing Details Controller!!!");    	
        List<ListingDetails> listingDetails = listingDetailsService.getAllListingDetails();
        model.addAttribute("listingDetails", listingDetails);
        System.out.println("details fetched: "+listingDetails);
        return "testListingDetails";
    }

    @GetMapping
    public List<ListingDetails> getAllListingDetails() {
        return listingDetailsService.getAllListingDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingDetails> getListingDetailsById(@PathVariable Long id) {
        ListingDetails listingDetails = listingDetailsService.getListingDetailsById(id);
        if (listingDetails != null) {
            return new ResponseEntity<>(listingDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

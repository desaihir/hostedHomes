// DashboardController.java
package com.example.controller;

import com.example.pojo.Image;
import com.example.pojo.Reservation;
import com.example.pojo.Comment;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;
import com.example.service.CommentService;
import com.example.service.ImageService;
import com.example.service.ListingDetailsService;
import com.example.service.ListingService;
import com.example.service.ReservationService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    private static final int PAGE_SIZE = 8; // Number of listings per page

    @Autowired
    private ListingService listingService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ListingDetailsService listingDetailsService;

    @Autowired
    private CommentService commentService;
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model, @RequestParam(defaultValue = "0") int page, HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	// Add username to the model
        model.addAttribute("username", username);
    	System.out.println("---------------------------------------");
        System.out.println("Username: " + username);
    	System.out.println("---------------------------------------");
    	System.out.println("entered Dashboard Controller!!");
    	System.out.println("---------------------------------------");
        // Fetch listings from the database with pagination
        List<Listing> listings = listingService.getAllListings(page, PAGE_SIZE);
        
        // Fetch primary images for each listing
        Map<Long, Image> primaryImages = new HashMap<>();
        for (Listing listing : listings) {
        	System.out.println("---------------------------------------");
        	System.out.println("Listing fetched!");
        	System.out.println("---------------------------------------");
            Image primaryImage = imageService.getPrimaryImageByListingId(listing.getId());
            primaryImages.put(listing.getId(), primaryImage);
        }

        // Fetch listing details for each listing
        Map<Long, ListingDetails> listingDetailsMap = new HashMap<>();
        for (Listing listing : listings) {
        	System.out.println("---------------------------------------");
        	System.out.println("Listing Details fetched!");
        	System.out.println("---------------------------------------");
            ListingDetails listingDetails = listingDetailsService.getListingDetailsById(listing.getId());
            System.out.println(listingDetails);
            listingDetailsMap.put(listing.getId(), listingDetails);
        }

        // Add data to the model
        model.addAttribute("listings", listings);
        model.addAttribute("primaryImages", primaryImages);
        model.addAttribute("listingDetailsMap", listingDetailsMap);

        // Add pagination information to the model
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", listingService.getTotalPages(PAGE_SIZE));

        return "dashboard";
    }
    
    
    
    @GetMapping("/dashboard/search")
    public String showSearchDashboard(Model model, HttpSession session, @RequestParam String location ) {
    	String username = (String) session.getAttribute("username");
    	// Add username to the model
        model.addAttribute("username", username);
    	System.out.println("---------------------------------------");
        System.out.println("Username: " + username);
        System.out.println("Location: " + location);
    	System.out.println("---------------------------------------");
    	System.out.println("entered showSearchDashboard !!");
    	System.out.println("---------------------------------------");
        // Fetch listings from the database with pagination
        List<Listing> listings = listingService.getListingsByLocation(location); 
        System.out.println("---------------------------------------");
    	System.out.println("listings fetched : "+listings);    	
    	System.out.println("---------------------------------------");
    	
//        // Fetch primary images for each listing
//        Map<Long, Image> primaryImages = new HashMap<>();
//        for (Listing listing : listings) {
//        	System.out.println("---------------------------------------");
//        	System.out.println("Listing fetched in showSearchDashboard !");
//        	System.out.println("---------------------------------------");
//            Image primaryImage = imageService.getPrimaryImageByListingId(listing.getId());
//            primaryImages.put(listing.getId(), primaryImage);
//        }

        // Fetch listing details for each listing
        	System.out.println("---------------------------------------");
        	System.out.println("Listing Details fetched in showSearchDashboard!");        
        	System.out.println("---------------------------------------");
        	// !!!!!!! IMPLEMENT !!!!!!
        	Map<Long, List<ListingDetails>> listingDetailsMap = new HashMap<>();
        	List<ListingDetails> listingDetailsList = listingDetailsService.getListingDetailsByLocation(location);
        	for (ListingDetails details : listingDetailsList) {
        	    if (!listingDetailsMap.containsKey(details.getListingDetailsId())) {
        	        listingDetailsMap.put(details.getListingDetailsId(), new ArrayList<>());
        	    }
        	    listingDetailsMap.get(details.getListingDetailsId()).add(details);
        	}

            System.out.println("---------------------------------------");
            System.out.println("listing Details fetched : "+listingDetailsList);
            System.out.println("---------------------------------------");
        // Add data to the model
        model.addAttribute("listings", listings);
//        model.addAttribute("primaryImages", primaryImages);
        model.addAttribute("listingDetailsMap", listingDetailsMap);

//         Add pagination information to the model
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", listingService.getTotalPages(PAGE_SIZE));

        return "searchDashboard";
    }

    
    @GetMapping("/viewListing")
    public String viewListing(Model model, @RequestParam Long listingId) {
    	System.out.println("---------------------------------------");
    	System.out.println("Listing ID retrieved : "+listingId);    	
    	System.out.println("---------------------------------------");
        // Fetch listing details by listingId
        Listing listing = listingService.getListingById(listingId);
        ListingDetails listingDetails = listingDetailsService.getListingDetailsById(listingId);
        List<Comment> comment = commentService.getCommentsByListingId(listingId);
        List<Date> bookedDates = reservationService.getBookedDatesByListingId(listingId);
        System.out.println("---------------------------------------");
    	System.out.println("Listing retrieved : "+listing);    	
    	System.out.println("---------------------------------------");
    	System.out.println("Listing details retrieved : "+listingDetails);    	
    	System.out.println("---------------------------------------");
    	System.out.println("Comments retrieved : "+comment);    	
    	System.out.println("---------------------------------------");

        // Add listing and listing details to the model
        model.addAttribute("listing", listing);
        model.addAttribute("listingDetails", listingDetails);
        model.addAttribute("comment",comment);
        model.addAttribute("bookedDates", bookedDates);

        return "viewListing";
    }

}
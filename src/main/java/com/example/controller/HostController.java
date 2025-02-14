package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.Comment;
import com.example.pojo.Listing;
import com.example.pojo.ListingDetails;
import com.example.service.CommentService;
import com.example.service.ListingDetailsService;
import com.example.service.ListingService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/host")
public class HostController {

    @Autowired
    private ListingService listingService;

    @Autowired
    private ListingDetailsService listingDetailsService;
    
    @Autowired
    private CommentService commentService;

    @GetMapping("/dashboard")
    public String hostDashboard(Model model, HttpSession session) {
        // Retrieve username from the session
        String username = (String) session.getAttribute("username");
        System.out.println("---------------------------------------");
    	System.out.println("entered Host Dashboard Controller!!");
    	System.out.println("---------------------------------------");

        // Fetch host's listings from the database based on the username
        List<Listing> hostListings = listingService.getListingsByUsername(username);

        // Pass the fetched listings to the view
        model.addAttribute("listings", hostListings);

        return "hostDashboard";
    }

    @GetMapping("/createListing")
    public String showCreateListingForm(Model model, HttpSession session) {
    	String username = (String) session.getAttribute("username"); 
    	System.out.println("---------------------------------------");
    	System.out.println("Username in getMapping in /createListing : "+ username);
    	System.out.println("---------------------------------------");
        model.addAttribute("listing", new Listing());
        model.addAttribute("listingDetails", new ListingDetails());
        return "createListingForm";
    }

    @PostMapping("/createListing")
    public String createListing(@ModelAttribute("listing") Listing listing,
                                @ModelAttribute("listingDetails") ListingDetails listingDetails,
                                HttpSession session) {
        // Retrieve the username from the session
        String username = (String) session.getAttribute("username"); 
        System.out.println("---------------------------------------");
    	System.out.println("Username in postMapping in /createListing : "+ username);
    	System.out.println("---------------------------------------");
        // Logic to save the new listing and its details
        listingService.createListing(listing, username);
        listingDetailsService.createListingDetails(listingDetails);
        
        return "redirect:/host/dashboard";
       // return "hostDashboard";
    }

    @GetMapping("/editListing/{listingId}")
    public String showEditListingForm(@PathVariable Long listingId, Model model) {
        // Logic to fetch listing and its details for editing
        Listing listing = listingService.getListingById(listingId);
        ListingDetails listingDetails = listingDetailsService.getListingDetailsById(listingId);
        model.addAttribute("listing", listing);
        model.addAttribute("listingDetails", listingDetails);
        return "editListingForm";
    }

    @PostMapping("/editListing/{listingId}")
    public String editListing(@PathVariable Long listingId,
                              @ModelAttribute("listing") Listing listing,
                              @ModelAttribute("listingDetails") ListingDetails listingDetails,
                              HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	System.out.println("---------------------------------------");
    	System.out.println("Username in postMapping in /editListing : "+ username);
    	System.out.println("---------------------------------------");
        // Logic to update the listing and its details
    	Listing existingListing = listingService.getListingById(listingId);
        
        // Ensure that the existing listing_id is not modified
        listing.setId(existingListing.getId());
        
        // Update the listing using the service method
        listingService.updateListing(listing, username);
        listingDetailsService.updateListingDetails(listingDetails, listingId);
        return "redirect:/host/dashboard";
    }    
    
//    @PostMapping("/updateListing/{listingId}")
//    public String updateListing(@PathVariable Long listingId, @ModelAttribute("listing") Listing listing) {
//        // Fetch the existing listing_id associated with the listing being updated
//        Listing existingListing = listingService.getListingById(listingId);
//        
//        // Ensure that the existing listing_id is not modified
//        listing.setId(existingListing.getId());
//        
//        // Update the listing using the service method
//        listingService.updateListing(listing);
//        
//        return "redirect:/host/dashboard";
//    }

    @PostMapping("/deleteListing/{listingId}")
    public String deleteListing(@PathVariable Long listingId) {
        // Logic to delete the listing and its details
        listingService.deleteListing(listingId);
        listingDetailsService.deleteListingDetails(listingId);
        return "redirect:/host/dashboard";
    }

    @GetMapping("/viewListing/{listingId}")
    public String viewListing(@PathVariable Long listingId, Model model) {
        // Logic to fetch and display the details of a specific listing
        Listing listing = listingService.getListingById(listingId);
        ListingDetails listingDetails = listingDetailsService.getListingDetailsById(listingId);
        List<Comment> comment = commentService.getCommentsByListingId(listingId);
        model.addAttribute("listing", listing);
        model.addAttribute("listingDetails", listingDetails);
        model.addAttribute("comment",comment);
        return "hostViewListing";
    }
}
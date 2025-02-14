package com.example.controller;

import com.example.pojo.Listing;
import com.example.pojo.Reservation;
import com.example.pojo.User;
import com.example.service.EmailService;
import com.example.service.ListingService;
import com.example.service.PDFGeneratorService;
import com.example.service.ReservationService;
import com.example.service.UserService;
import com.lowagie.text.DocumentException;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private ListingService listingService;
    
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;
    
    @Autowired
    private PDFGeneratorService pdfGeneratorService;
  
    @PostMapping
    public String addReservation(@ModelAttribute Reservation reservation, HttpSession session, @RequestParam Long listingId, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate ) {
        String username = (String) session.getAttribute("username");       
        System.out.println("---------------------------------------");
        System.out.println("ListingId: " + reservation.getListingId());
    	System.out.println("---------------------------------------");
    	System.out.println("entered addReservation function in ReservationController !!");
    	System.out.println("---------------------------------------");
    	
    	reservationService.addReservation(reservation, username, listingId, startDate, endDate);
    	
    	Listing thisListing = listingService.getListingById(listingId); 
    	User thisUser = userService.findByUsername(username);
    	
    	try {
			emailService.sendReservationEmail(thisUser, reservation, thisListing);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	  return "userReservationsPage";
//    		return "redirect:/reservations/user/{reservation.username}";
        return "redirect:/viewListing?listingId=" + reservation.getListingId();
    }
    
    
    @GetMapping("/confirmation/pdf/generate")
    public void generatePDF(HttpServletResponse response) throws IOException {
    	System.out.println("---------------------------------------");
    	System.out.println("entered generatePDF function in ReservationController !!");
    	System.out.println("---------------------------------------");
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Reservation_Confirmation_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        
        try {
            this.pdfGeneratorService.generatePDF(response);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    
    
    
    @GetMapping("/edit/{reservationId}")
    public String showEditReservationForm(@PathVariable Long reservationId, Model model ) {
    	System.out.println("---------------------------------------");
    	System.out.println("entered @getMapping /editReservation function in ReservationController !!");
    	System.out.println("---------------------------------------");
    	Reservation reservation = reservationService.getReservationById(reservationId);
    	model.addAttribute("reservation", reservation);
    	return "editReservationForm";
    }            
    
    
    @PostMapping("/edit/{reservationId}")
    public String updateReservation(@PathVariable Long reservationId,
    								@ModelAttribute("reservation") Reservation reservation,
    								HttpSession session) { 
    	System.out.println("---------------------------------------");
    	System.out.println("HELLO!");
    	System.out.println("---------------------------------------");
    	String username = (String) session.getAttribute("username");
//    	System.out.println("---------------------------------------");
    	System.out.println("Username in postMapping in /editReservation : "+ username);
    	System.out.println("---------------------------------------");
    	
    	Reservation existingReservation = reservationService.getReservationById(reservationId);        
    	reservation.setListingId(existingReservation.getListingId());
        reservationService.updateReservation(reservation, username);
        System.out.println("---------------------------------------");
        System.out.println("HELLO post update!");
    	System.out.println("---------------------------------------");
        return "redirect:/dashboard";
//        return "redirect:/reservations/user/${reservation.username}";
//    	return "redirect:/reservations/user/{username}";
    	
    }
    
        
    

//    @DeleteMapping("/{reservationId}")
    @PostMapping("/cancel/{reservationId}")
    public String cancelReservation(@PathVariable Long reservationId, HttpSession session) {        
        String username = (String) session.getAttribute("username");
        System.out.println("---------------------------------------");
    	System.out.println("Currently in posttMapping in /cancelReservation !");
    	System.out.println("---------------------------------------");
    	reservationService.cancelReservation(reservationId);
        return "redirect:/dashboard";
//        return "redirect:/reservations/user/{username}";
    }
    
    

    @GetMapping("/user/{username}")
    public String getUserReservations(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        System.out.println("---------------------------------------");
    	System.out.println("Username in gettMapping in /getUserReservation : "+ username);
    	System.out.println("---------------------------------------");
    	
        List<Reservation> userReservations = reservationService.getReservationsByUsername(username);
        model.addAttribute("userReservations", userReservations);
        return "userReservationsPage";
    }
    
    @GetMapping("host/{listingId}")
    public String getListingReservations(@PathVariable Long listingId, HttpSession session, Model model) {
    	String username = (String) session.getAttribute("username");
        System.out.println("---------------------------------------");
    	System.out.println("Username in gettMapping in /getUserReservation : "+ username);
    	System.out.println("---------------------------------------");
    	 List<Reservation> hostReservations = reservationService.getReservationsByListingId(listingId);
         model.addAttribute("hostReservations", hostReservations);
         return "hostReservationsPage";
    }
}

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;

import com.example.pojo.Listing;
import com.example.pojo.Reservation;
import com.example.pojo.User;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendRegistrationEmail(User user) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(user.getEmail());
        helper.setFrom(senderEmail);
        helper.setSubject("Welcome to HostedHomes - Welcome home, wherever you roam!");
        String emailContent = "Dear " + user.getFirstName() + ",\n\n"
                + "Welcome aboard! 🚀 We're thrilled to have you join us at HostedHomes and embark on this exciting journey together.\n\n"
                + "At HostedHomes, we're committed to providing you with the best experience possible when you're searching for your dream accommodation for your dream trip.\n\n"
                + "We're here to support you every step of the way, so don't hesitate to reach out if you have any questions or need assistance. Your journey starts here, and we can't wait to see where it takes you!\n\n"
                + "Once again, welcome to HostedHome. Let's find your home away from home!\n"
                + "\n"
                + "Happy travels!\n\n"
                + "Best regards,\n"
                + "Hir Desai\n"
                + "Developer\n"
                + "[HostedHomes]";
        helper.setText(emailContent);
        emailSender.send(message);
    }
    
    public void sendReservationEmail(User user, Reservation reservation, Listing listing) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(user.getEmail());
        helper.setFrom(senderEmail);
        helper.setSubject("[HostedHomes] Reservation Confirmation");
        String emailContent = "Dear " + user.getFirstName() + ",\n\n"
                + "Thank you for choosing our service! We are delighted to confirm your reservation.\n\n"
                + "Reservation Details:\n\n"
                + "Listing Name: " +  listing.getListingName() +"\n"
                + "Check-in Date: " + reservation.getStartDate() + "\n"
                + "Check-out Date: " + reservation.getEndDate() + "\n"
//                + "Total Price: \n\n" LengthOfStay * Cost
                + "\nYour reservation is confirmed, and we are looking forward to hosting you. Should you have any questions or need further assistance, feel free to reach out to us.\n"
                + "\n"
                + "Thank you once again for choosing our service. We wish you a pleasant stay!\n"
                + "\n"
                + "Best regards,\n"
                + "[HostedHomes]";
        helper.setText(emailContent);
        emailSender.send(message);
    }
}

package com.example.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.pojo.Listing;
import com.example.pojo.Reservation;
import com.example.pojo.User;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PDFGeneratorService {
	
//	public void generatePDF(HttpServletResponse response, User user, Reservation reservation, Listing listing) throws DocumentException, IOException {
//	public void generatePDF(HttpServletResponse response) throws DocumentException, IOException {
//		Document document = new Document(PageSize.A4);
//		PdfWriter.getInstance(document, response.getOutputStream());
//		
//		
//		document.open();
//		Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//		fontTitle.setSize(18);
//				
//        Paragraph title = new Paragraph("Reservation Confirmation", fontTitle);
//        title.setAlignment(Paragraph.ALIGN_CENTER);
//        document.add(title);
//        
//        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
//        fontParagraph.setSize(12);
//        
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//        String currentDateTime = dateFormatter.format(new Date());
//
//        Font fontDateTime = FontFactory.getFont(FontFactory.HELVETICA);
//        fontDateTime.setSize(10);
//
//        Chunk dateTimeChunk = new Chunk(currentDateTime, fontDateTime);
//        Phrase dateTimePhrase = new Phrase(dateTimeChunk);
//        Paragraph dateTimeParagraph = new Paragraph(dateTimePhrase);
//        dateTimeParagraph.setAlignment(Element.ALIGN_RIGHT);
//
//        
//        Paragraph salutation = new Paragraph("Hello,",fontParagraph);
//		Paragraph content = new Paragraph("This is to confirm that your reservation has been successfully made.\n\n Reservation Details:\n",fontParagraph);
////		content.add("Reservation ID: " + reservation.getReservationId() + "\n");
////		content.add("Listing Name: " + listing.getListingName() + "\n");
////		content.add("Location: " + listing.getLocation() + "\n");
////		content.add("Start Date: " + reservation.getStartDate() + "\n");
////		content.add("End Date: " + reservation.getEndDate() + "\n\n");
////		content.add("Length of Stay: " + reservation.getLengthOfStay() + " nights\n\n");
//		content.add("You should be receiving an email confirmation for your Reservation within few minutes (at max). In the meantime, you may check your reservation details on your User Dashboard > View Reservations. You may edit or cancel your reservation from there.\n");
//		content.add("TYou shall soon receive the exact address of your stay.\n\n");
//		content.add("Thank you for choosing our service. We look forward to hosting you!\n\n");
//		content.add("Best regards,\n");
//		content.add("[HostedHomes]");
//
//        document.add(salutation);
//        document.add(content);
//        
//        document.close();
//		
//	}
//	
//}
	public void generatePDF(HttpServletResponse response) throws DocumentException, IOException {
		
		System.out.println("---------------------------------------");
	    System.out.println("Entered generatePDF in PDFGeneratorService !");
	    System.out.println("---------------------------------------");
	    
	    Document document = new Document(PageSize.A4);
	    PdfWriter.getInstance(document, response.getOutputStream());
    
	    document.open();
	    Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	    fontTitle.setSize(18);
	            
	    Paragraph title = new Paragraph("Reservation Confirmation", fontTitle);
	    title.setAlignment(Paragraph.ALIGN_CENTER);
	    document.add(title);
	    
	    Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
	    fontParagraph.setSize(12);
	    
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	    String currentDateTime = dateFormatter.format(new Date());
	
	    Font fontDateTime = FontFactory.getFont(FontFactory.HELVETICA);
	    fontDateTime.setSize(10);
	
	    Chunk dateTimeChunk = new Chunk(currentDateTime, fontDateTime);
	    Phrase dateTimePhrase = new Phrase(dateTimeChunk);
	    Paragraph dateTimeParagraph = new Paragraph(dateTimePhrase);
	    dateTimeParagraph.setAlignment(Element.ALIGN_RIGHT);
	    
	    Paragraph salutation = new Paragraph("Hello,", fontParagraph);
	    Paragraph content = new Paragraph("This is to confirm that your reservation has been successfully made.\n\n Reservation Details:\n", fontParagraph);
	    content.add("You should be receiving an email confirmation for your Reservation within few minutes (at max). In the meantime, you may check your reservation details on your User Dashboard > View Reservations. You may edit or cancel your reservation from there.\n");
	    content.add("You shall soon receive the exact address of your stay.\n\n");
	    content.add("Thank you for choosing our service. We look forward to hosting you!\n\n");
	    content.add("Best regards,\n");
	    content.add("[HostedHomes]");

	    document.add(salutation);
	    document.add(content);
	    
	    System.out.println("---------------------------------------");
	    System.out.println("Reached end in generatePDF in PDFGeneratorService !");
	    System.out.println("---------------------------------------");
	    
	    document.close();
	    
	    System.out.println("---------------------------------------");
	    System.out.println("END--> generatePDF in PDFGeneratorService !");
	    System.out.println("---------------------------------------");
	}
}
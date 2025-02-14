<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/hostViewListing.css">
    <title>Host View Listing</title>
</head>
<body>
    <div class="navbar">        
        <a href="/host/dashboard">Host Dashboard</a>
    </div>
    
    <div class="listing-details">
        <h1>${listing.listingName}</h1>
        <p><strong>Location:</strong> ${listing.location}</p>
        <p><strong>Cost:</strong> ${listingDetails.cost}</p>
        <p><strong>Beds:</strong> ${listingDetails.beds}</p>
        <p><strong>Baths:</strong> ${listingDetails.baths}</p>
        <p><strong>Ratings:</strong> ${listingDetails.ratings}</p>
        
        <div class="actions">
            <a href="/host/editListing/${listing.id}">Edit</a>
             <a href="/reservations/host/${listing.id}">View Reservations</a>
            <form action="/host/deleteListing/${listing.id}" method="post" style="display: inline;">
                <button type="submit">Delete</button>
            </form>
        </div>
    </div>
    
    <div class="comments">
        <h2>Comments</h2>
        <c:forEach items="${comment}" var="comment">
            <div class="comment">
                <p class="username">${comment.username}</p>
                <p>${comment.comment}</p>
                <p class="timestamp">${comment.createdAt}</p>
            </div>
        </c:forEach>
    </div>
    
    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2024 ~Hosted Homes</p>
    </div>
</body>
</html>

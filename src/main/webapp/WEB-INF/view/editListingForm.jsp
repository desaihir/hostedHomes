<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/editListingForm.css">
    <title>Edit Listing</title>
</head>
<body>
    <h1>Edit Listing</h1>
    <form action="/host/editListing/${listing.id}" method="post">
        <label for="listingName">Listing Name:</label>
        <input type="text" id="listingName" name="listingName" value="${listing.listingName}" required><br><br>
        
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" value="${listing.location}" required><br><br>
        
        <label for="cost">Cost:</label>
        <input type="number" id="cost" name="cost" value="${listingDetails.cost}" required><br><br>
        
        <label for="beds">Beds:</label>
        <input type="number" id="beds" name="beds" value="${listingDetails.beds}" required><br><br>
        
        <label for="baths">Baths:</label>
        <input type="number" id="baths" name="baths" value="${listingDetails.baths}" required><br><br>
        
        <label for="ratings">Ratings:</label>
        <input type="number" id="ratings" name="ratings" value="${listingDetails.ratings}" required><br><br>
        
        <button type="submit">Update Listing</button>
    </form>
    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2024 ~Hosted Homes</p>
    </div>
</body>
</html>
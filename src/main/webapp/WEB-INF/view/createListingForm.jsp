<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/createListingForm.css">
    <title>Create Listing</title>
</head>
<body>
    <h1>Create New Listing</h1>
    <form action="/host/createListing" method="post">
        <label for="listingName">Listing Name:</label>
        <input type="text" id="listingName" name="listingName" required><br><br>
        
        <label for="location">Location:</label>
        <input type="text" id="location" name="location" required><br><br>
        
        <label for="cost">Cost:</label>
        <input type="number" id="cost" name="cost" required><br><br>
        
        <label for="beds">Beds:</label>
        <input type="number" id="beds" name="beds" required><br><br>
        
        <label for="baths">Baths:</label>
        <input type="number" id="baths" name="baths" required><br><br>
        
        <label for="ratings">Ratings:</label>
        <input type="number" id="ratings" name="ratings" required><br><br>
        
        <button type="submit">Create Listing</button>
    </form>
    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2024 ~Hosted Homes</p>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/viewListing.css">
    <link rel="stylesheet" type="text/css" href="/css/calendar.css">
    <title>View Listing</title>
</head>
<body>
    <div class="navbar">
		<!-- Navbar -->
		<a href="/dashboard">User Mode</a>
	</div>
    <div class="listing-details">
        <h1>${listing.listingName}</h1>
        <!-- <h2>Listing Information</h2> -->
        <%-- <p><strong>Title:</strong> ${listings.listingName}</p> --%>

        <h2>Listing Details</h2>
        <p><strong>Location:</strong> ${listingDetails.location}</p>
        <p><strong>Cost:</strong> ${listingDetails.cost}</p>
        <p><strong>Beds:</strong> ${listingDetails.beds}</p>
        <p><strong>Baths:</strong> ${listingDetails.baths}</p>
        <p><strong>Ratings:</strong> ${listingDetails.ratings}</p>
    </div>
    
    <!-- <div class="calendar">
        Calendar
        <h2>Availability Calendar</h2>
        <table id="calendar">
            Calendar content will be generated here
        </table>
    </div> -->
    
    <!-- Date selection form -->
    <div class="reservation-form">
        <h2>Make a Reservation</h2>
        <form action="/reservations" method="post">
            <input type="hidden" name="listingId" value="${listing.id}">
            <label for="startDate">Start Date:</label>
            <input type="date" id="startDate" name="startDate" required pattern="\d{4}-\d{2}-\d{2}" required>
            <label for="endDate">End Date:</label>
            <input type="date" id="endDate" name="endDate" required pattern="\d{4}-\d{2}-\d{2}" required>
            <button type="submit">Submit Reservation</button>
        </form>
    </div>
    
    <div class="comments">
        <h2>Comments</h2>
        <c:forEach items="${comment}" var="comment">
            <p><strong>Username:</strong> ${comment.username} ${comment.createdAt}</p>
            <p><strong>Comment:</strong> ${comment.comment}</p>
        </c:forEach>
        <form action="/comments" method="post" enctype="application/x-www-form-urlencoded">
            <input type="hidden" name="listingId" value="${listing.id}">
            <textarea name="comment" placeholder="Write your comment here" required></textarea>
            <button type="submit">Submit</button>
        </form>
    </div>
    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2024 Hosted Homes</p>
    </div>

    <!-- Embedded booked dates -->
    <script>
        var bookedDates = ${bookedDates}; // Retrieve booked dates from server-side
        var unavailableDates = [];
        // Convert booked dates to ISO format
        bookedDates.forEach(function(date) {
            unavailableDates.push(new Date(date).toISOString().slice(0, 10));
        });
        document.getElementById('startDate').addEventListener('input', function() {
            var startDate = new Date(this.value);
            var endDateInput = document.getElementById('endDate');
            var endDate = new Date(endDateInput.value);
            if (startDate > endDate || unavailableDates.includes(this.value)) {
                endDateInput.value = '';
            }
        });
        document.getElementById('endDate').addEventListener('input', function() {
            var endDate = new Date(this.value);
            var startDateInput = document.getElementById('startDate');
            var startDate = new Date(startDateInput.value);
            if (endDate < startDate || unavailableDates.includes(this.value)) {
                startDateInput.value = '';
            }
        });
    </script>
    <script src="/js/calendar.js"></script>
</body>
</html>

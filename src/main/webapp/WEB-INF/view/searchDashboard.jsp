<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/dashboard.css">

<title>Dashboard</title>
</head>
<body>
	<div class="navbar">
		<!-- Navbar -->
		<a href="/login">Login Page</a>
		<a href="/host/dashboard">Host Mode</a> 
		<a
			href="/reservations/user/{username}">My Reservations</a>
	</div>

	<div class="search-bar">
		<!-- Search bar -->
		<form action="/dashboard/search" method="GET">
			<input type="text" name="location" placeholder="Enter city">
			<button type="submit">Search</button>
		</form>
	</div>

	<div class="listings">
		<!-- Listings -->
		<c:forEach items="${listings}" var="listing">
			<div class="listing-item">
				<img src="${primaryImages[listing.id].imageUrl}" alt="Listing Image">
				<h3>${listing.listingName}</h3>
				<p>in ${listing.location}</p>
				<p>				
					<c:forEach items="${listingDetailsMap[listing.id]}" var="details">
    					<p>Cost per night: ${details.cost}</p>
					</c:forEach>

				</p>

				<form action="/viewListing" method="get">
					<input type="hidden" name="listingId" value="${listing.id}">
					<button type="submit">View Listing</button>
				</form>
			</div>
		</c:forEach>
	</div>

	<div class="pagination">
		<!-- Pagination links go here -->
		<c:if test="${currentPage > 0}">
			<a href="?page=${currentPage - 1}">Previous</a>
		</c:if>

		Page ${currentPage + 1} of ${totalPages}

		<c:if test="${currentPage < totalPages - 1}">
			<a href="?page=${currentPage + 1}">Next</a>
		</c:if>
	</div>

	<div class="footer">
		<!-- Footer content goes here -->
		<p>&copy; 2024 ~Hosted Homes</p>
	</div>
</body>
</html>

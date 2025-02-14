<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/hostDashboard.css">
<title>Host Dashboard</title>
</head>
<body>
	<div class="navbar">
		<!-- Navbar -->
		<a href="/dashboard">User Mode</a>
	</div>
	<div class=host-dashboard>
		<h1>Host Dashboard</h1>
		<a href="/host/createListing">Create New Listing</a>
		<hr>
		<%-- Retrieve username from session --%>
		<c:set var="username" value="${sessionScope.username}" />
		<%-- Print username --%>
		<p>Welcome: ${username}</p>
		<hr>
		<h2>Your Listings:</h2>
		<ul>
			<c:forEach items="${listings}" var="listing">
				<li>${listing.listingName}- ${listing.location} <a
					href="/host/viewListing/${listing.id}">View</a> <%-- <a href="/host/editListing/${listing.id}">Edit</a>
                <form action="/host/deleteListing/${listing.id}" method="post" style="display: inline;">
                    <button type="submit">Delete</button>
                </form> --%>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div class="footer">
		<!-- Footer content goes here -->
		<p>&copy; 2024 ~Hosted Homes</p>
	</div>
</body>
</html>

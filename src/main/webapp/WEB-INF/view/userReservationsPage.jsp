<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Reservations</title>
<link rel="stylesheet" type="text/css" href="/css/userReservationsPage.css">
</head>
<body>
<div class="navbar">
		<!-- Navbar -->
		<a href="/dashboard">User Mode</a>
	</div>
<h2>Your Reservations</h2>
<!-- <a href="/dashboard">User Mode</a> -->
<table>
    <!-- Table headers -->
    <tr>
        <th>Reservation ID</th>
        <th>Start Date</th>
        <th>End Date</th>
        <!-- Other columns as needed -->
        <th>Actions</th>
    </tr>
    <!-- Table rows for each reservation -->
    <c:forEach var="reservation" items="${userReservations}">
        <tr>
            <td>${reservation.reservationId}</td>
            <td>${reservation.startDate}</td>
            <td>${reservation.endDate}</td>
            <!-- Other columns as needed -->
            <td>
                <a href="/reservations/edit/${reservation.reservationId}">Edit</a>
                <!-- <a href="/reservations/cancel/${reservation.reservationId}">Cancel</a>-->
                <form action="/reservations/cancel/${reservation.reservationId}" method="post" style="display: inline;">
                <button type="submit">Cancel Booking</button>
                
                <!-- <form action="/reservations/confirmation/pdf/generate" method="get" style="display: inline;">
                <button type="submit">Reservation Confirmation</button> -->
                
                <a href="/reservations/confirmation/pdf/generate">Reservation Confirmation</a>
                
            </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/hostReservationsPage.css">
</head>
<body>
<div class="navbar">
		<!-- Navbar -->
		<a href="/host/dashboard">Host Dashboard</a>
	</div>
<table>
    <!-- Table headers -->
    <tr>
        <th>Reservation ID</th>
        <th>User</th>
        <th>Start Date</th>
        <th>End Date</th>
        <!-- Other columns as needed -->
    </tr>
    <!-- Table rows for each reservation -->
    <c:forEach var="reservation" items="${hostReservations}">
        <tr>
            <td>${reservation.reservationId}</td>
            <td>${reservation.username}</td>
            <td>${reservation.startDate}</td>
            <td>${reservation.endDate}</td>
            <!-- Other columns as needed -->
        </tr>
    </c:forEach>
</table>

</body>
</html>
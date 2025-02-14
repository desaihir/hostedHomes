<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Reservation</title>
</head>
<body>
    <h1>Edit Reservation</h1>
    <form action="/reservations/edit/${reservation.reservationId}" method="post">
        <input type="hidden" name="reservationId" value="${reservation.reservationId}">
        
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" value="${reservation.startDate}">
        
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" value="${reservation.endDate}">
        
        <button type="submit">Update Reservation</button>
    </form>
</body>
</html>

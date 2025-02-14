<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
		<title>Registration</title>
	</head>
	<body>
	    <h2>Registration</h2>
	
	    <%-- Display any error messages --%>
	    <c:if test="${error != null}">
	        <p style="color: red;">${error}</p>
	    </c:if>
	
	    <form action="/register" method="post">
	        <input type="text" name="username" placeholder="Username" required><br>
	        <input type="text" name="firstName" placeholder="First Name" required><br>
	        <input type="text" name="lastName" placeholder="Last Name" required><br>
	        <input type="email" name="email" placeholder="Email" required><br>
	        <input type="text" name="phoneNumber" placeholder="Phone Number" required><br>
	        <input type="password" name="password" placeholder="Password" required><br>
	        <button type="submit">Register</button>
	    </form>
	    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2024 ~Hosted Homes</p>
    </div>
	</body>
</html>
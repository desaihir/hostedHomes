<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/login.css">
		
		<title>Login</title>
	</head>
	<body>
	<section>
			<header>
				<a href='#' class="logo"><img src="logoBrbg.png"></a>
			</header>
		</section>
	    <h2>Login</h2>
	    <form action="/login" method="post">
	        <input type="text" name="username" placeholder="Username" required>
	        <br>
	        <input type="password" name="password" placeholder="Password" required>
	        <br>
	        <button type="submit">Login</button>
	    </form>
	    <p>Don't have an account? <a href="/register">Register here</a></p>
	    <div class="footer">
        <!-- Footer content goes here -->
        <p>&copy; 2024 ~Hosted Homes</p>
    </div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Submit Review</title>
    <link rel="stylesheet" href="styles_C.css"> 
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css"> 
    <script src="scripts_C.js" defer></script>  
</head>
<body>
	<header>
	<div class="header-1">
            <a class="logo"><i class="uil uil-restaurant"></i> EasyEats </a>
    </div>
    </header>
    <div class="form-container">
        <h2>Submit Your Review</h2>
        <form action="CreateServlet" method="post" id="reviewForm" onsubmit="return validateForm()">
            <label for="user_id">User ID:</label>
            <input type="text" id="user_id" name="user_id" required><br>

            <label for="rating">Rating (1-5):</label>
            <input type="number" id="rating" name="rating" min="1" max="5" required><br>

            <label for="review_text">Review:</label>
            <textarea id="review_text" name="review_text" required></textarea><br>

            <button type="submit">Submit Review</button>
        </form>

        <div id="message" class="message-popup"></div>  
    </div>
</body>
</html>
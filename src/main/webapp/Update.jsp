<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Review</title>
    <link rel="stylesheet" href="styles_C.css"> 
    
</head>
<body>
	<div class=form-container>
	
    <h2>Edit Review</h2>

    <form action="UpdateServlet" method="post">
        <input type="hidden" name="reviewId" value="${param.reviewId}">

        <label for="rating">Rating (1-5):</label>
        <input type="number" id="rating" name="rating" min="1" max="5" required><br>

        <label for="review_text">Review:</label>
        <textarea id="review_text" name="review_text" required></textarea><br>

        <button type="submit">Update Review</button>
    </form>
    </div>
</body>
</html>

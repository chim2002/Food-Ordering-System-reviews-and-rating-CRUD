<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Reviews</title>
    <link rel="stylesheet" href="styles.css">  <!-- Link to CSS file -->
</head>
<body>
    <h2>All Reviews</h2>

    <table>
        <tr>
            <th>Review ID</th>
            <th>User ID</th>
            <th>Rating</th>
            <th>Review Text</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="review" items="${reviewsList}">
            <tr>
                <td>${review.reviewId}</td>
                <td>${review.userId}</td>
                <td>${review.rating}</td>
                <td>${review.reviewText}</td>
                <td>
                    <form action="Update.jsp" method="get" style="display: inline-block;">
                        <input type="hidden" name="reviewId" value="${review.reviewId}">
                        <button type="submit">Edit</button>
                    </form>
                    <form action="DeleteServlet" method="post" style="display: inline-block;">
                        <input type="hidden" name="reviewId" value="${review.reviewId}">
                        <button type="submit" onclick="return confirm('Are you sure you want to delete this review?');">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

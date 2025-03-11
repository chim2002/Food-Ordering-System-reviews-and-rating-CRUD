function validateUpdateForm() {
    const rating = document.getElementById("rating").value;
    const reviewText = document.getElementById("review_text").value;

    if (!rating || !reviewText) {
        alert("All fields are required!");
        return false;
    }

    if (rating < 1 || rating > 5) {
        alert("Rating must be between 1 and 5!");
        return false;
    }

    return true;  // Proceed with form submission
}
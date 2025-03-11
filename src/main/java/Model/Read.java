package Model;

public class Read {
    private int reviewId;
    private int userId;
    private int rating;
    private String reviewText;

    public Read(int reviewId, int userId, int rating, String reviewText) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public int getRating() {
        return rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
   
}

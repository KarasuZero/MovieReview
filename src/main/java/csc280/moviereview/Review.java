package csc280.moviereview;

public class Review {
    private String title;
    private String rating;
    private String review;

    public Review(String title, String rating, String review) {
        this.title = title;
        this.rating = rating;
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
}


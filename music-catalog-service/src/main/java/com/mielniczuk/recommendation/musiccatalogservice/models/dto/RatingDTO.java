package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

public class RatingDTO {

    private int id;
    private int rating;

    public RatingDTO() {
    }

    public RatingDTO(int id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

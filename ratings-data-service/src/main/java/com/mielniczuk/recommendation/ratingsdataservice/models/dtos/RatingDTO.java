package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;

public class RatingDTO {

    private int id;
    private int rating;

    public RatingDTO(int id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.rating = rating.getRating();
    }

    public RatingDTO() {
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }
}

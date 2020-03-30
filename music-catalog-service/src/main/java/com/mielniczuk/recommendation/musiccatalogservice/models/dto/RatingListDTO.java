package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import java.util.List;

public class RatingListDTO {

    public RatingListDTO(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }

    public RatingListDTO() {
    }

    private List<RatingDTO> ratings;

    public List<RatingDTO> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }
}

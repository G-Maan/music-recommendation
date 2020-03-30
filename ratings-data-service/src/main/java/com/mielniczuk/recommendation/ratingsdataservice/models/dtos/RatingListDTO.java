package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;


import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;

import java.util.List;
import java.util.stream.Collectors;

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

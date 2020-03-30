package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;

public class RatingDTO {

    private int id;
    private int value;

    public RatingDTO(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.value = rating.getValue();
    }

    public RatingDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

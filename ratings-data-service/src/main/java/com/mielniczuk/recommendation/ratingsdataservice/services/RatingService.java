package com.mielniczuk.recommendation.ratingsdataservice.services;

import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;

public interface RatingService {

    public RatingDTO getRating(int ratingId);

}

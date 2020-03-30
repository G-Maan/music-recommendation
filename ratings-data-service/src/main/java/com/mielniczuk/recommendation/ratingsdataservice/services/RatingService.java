package com.mielniczuk.recommendation.ratingsdataservice.services;

import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingListDTO;

public interface RatingService {

    public RatingDTO getRating(int ratingId);
    public RatingListDTO getUserRatings(int userId);

}

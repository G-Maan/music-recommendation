package com.mielniczuk.recommendation.ratingsdataservice.services;

import com.mielniczuk.recommendation.ratingsdataservice.mappers.RatingMapper;
import com.mielniczuk.recommendation.ratingsdataservice.mappers.UserRatingToUserRatingListMapper;
import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;
import com.mielniczuk.recommendation.ratingsdataservice.models.UserRating;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.UserRatingListDTO;
import com.mielniczuk.recommendation.ratingsdataservice.repositories.RatingRepository;
import com.mielniczuk.recommendation.ratingsdataservice.repositories.UserRatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    private final UserRatingRepository userRatingRepository;

    private final RatingMapper ratingMapper;

    private final UserRatingToUserRatingListMapper userRatingListMapper;

    public RatingDTO getRating(Long ratingId) {
        Optional<Rating> rating = ratingRepository.findById(ratingId);
        return rating.map(ratingMapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    public UserRatingListDTO getUserRatings(Long userId) {
        Optional<UserRating> userRating = userRatingRepository.findById(userId);
        return userRating.map(userRatingListMapper::toDTO).orElseThrow(NoSuchElementException::new);
    }
}

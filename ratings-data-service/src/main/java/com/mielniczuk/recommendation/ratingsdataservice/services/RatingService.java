package com.mielniczuk.recommendation.ratingsdataservice.services;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;
import com.mielniczuk.recommendation.ratingsdataservice.models.UserRating;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingListDTO;
import com.mielniczuk.recommendation.ratingsdataservice.repositories.RatingRepository;
import com.mielniczuk.recommendation.ratingsdataservice.repositories.UserRatingRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    private final UserRatingRepository userRatingRepository;

    public RatingService(RatingRepository ratingRepository,
                         UserRatingRepository userRatingRepository) {
        this.ratingRepository = ratingRepository;
        this.userRatingRepository = userRatingRepository;
    }

    public RatingDTO getRating(int ratingId) {
        Optional<Rating> rating = ratingRepository.findById(ratingId);
        if (rating.isPresent()) {
            return new RatingDTO(rating.get());
        } else {
            throw new NoSuchElementException();
        }
    }

    public RatingListDTO getUserRatings(int userId) {
        Optional<UserRating> userRating = userRatingRepository.findById(userId);
        return userRating.map(usr -> new RatingListDTO(usr.getRatings().stream().map(RatingDTO::new).collect(Collectors.toList()))).orElseThrow();
    }
}

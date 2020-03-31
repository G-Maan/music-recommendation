package com.mielniczuk.recommendation.ratingsdataservice.resources;

import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingListDTO;
import com.mielniczuk.recommendation.ratingsdataservice.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingsResource {

    private final RatingService ratingService;

    @GetMapping("/{ratingId}")
    public RatingDTO getRating(@PathVariable("ratingId") Long ratingId) {
        return this.ratingService.getRating(ratingId);
    }

    @GetMapping("/users/{userId}")
    public RatingListDTO getUserRatings(@PathVariable("userId") Long userId) {
        return ratingService.getUserRatings(userId);
    }

}

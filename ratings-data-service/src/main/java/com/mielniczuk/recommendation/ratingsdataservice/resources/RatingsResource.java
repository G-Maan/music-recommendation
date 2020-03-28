package com.mielniczuk.recommendation.ratingsdataservice.resources;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;
import com.mielniczuk.recommendation.ratingsdataservice.services.RatingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    private final RatingService ratingService;

    public RatingsResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/{ratingId}")
    public RatingDTO getRating(@PathVariable("ratingId") int ratingId) {
        return this.ratingService.getRating(ratingId);
    }

}

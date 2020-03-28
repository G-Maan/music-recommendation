package com.mielniczuk.recommendation.ratingsdataservice.resources;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/ratings")
public class RatingsResource {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") int movieId) {
        Random random = new Random();
        return new Rating(movieId, random.nextInt(11));
    }

}

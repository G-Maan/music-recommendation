package com.mielniczuk.recommendation.musiccatalogservice.services;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieRatingListDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MovieRatingService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMovieRatingListFallback")
    public MovieRatingListDTO getMovieRatingList(Long userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, MovieRatingListDTO.class);
    }

    private MovieRatingListDTO getMovieRatingListFallback(Long userId) {
        return new MovieRatingListDTO(new ArrayList<>());
    }

}

package com.mielniczuk.recommendation.musiccatalogservice.services;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieRatingListDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MovieRatingService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMovieRatingListFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public MovieRatingListDTO getMovieRatingList(Long userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, MovieRatingListDTO.class);
    }

    private MovieRatingListDTO getMovieRatingListFallback(Long userId) {
        return new MovieRatingListDTO(new ArrayList<>());
    }

}

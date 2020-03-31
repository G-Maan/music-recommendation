package com.mielniczuk.recommendation.musicinfoservice.resources;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate restTemplate;

    public MovieResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{movieId}")
    public MovieDTO getMovieInfo(@PathVariable("movieId") Long movieId) {
        System.out.println(movieId);
        MovieSummary movieSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
                MovieSummary.class
        );
        return new MovieDTO(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}

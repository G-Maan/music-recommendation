package com.mielniczuk.recommendation.musicinfoservice.resources;

import com.mielniczuk.recommendation.musicinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
        System.out.println(movieId);
        return new Movie(movieId, "Test");
    }

}

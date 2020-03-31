package com.mielniczuk.recommendation.musicinfoservice.resources;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDTO;
import com.mielniczuk.recommendation.musicinfoservice.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieResource {

    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public MovieDTO getMovieInfo(@PathVariable("movieId") Long movieId) {
        return movieService.getMovieSummaryFromMovieDB(movieId);
    }
}

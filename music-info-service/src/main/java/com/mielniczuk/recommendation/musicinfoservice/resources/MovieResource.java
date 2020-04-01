package com.mielniczuk.recommendation.musicinfoservice.resources;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDataDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieRatingIDListDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDataListDTO;
import com.mielniczuk.recommendation.musicinfoservice.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieResource {

    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public MovieDataDTO getMovieInfo(@PathVariable("movieId") Long movieId) {
        return movieService.getMovieSummaryFromMovieDB(movieId);
    }

    @PostMapping("/list")
    public MovieDataListDTO getMovieInfoList(@RequestBody MovieRatingIDListDTO movieRatingListDTO) {
        return movieService.getMovieSummaryListFromMovieDB(movieRatingListDTO);
    }
}

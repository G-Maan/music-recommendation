package com.mielniczuk.recommendation.musicinfoservice.services;

import com.mielniczuk.recommendation.musicinfoservice.mappers.MovieDBSummaryToMovieDataDTOMapper;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDataDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieRatingIDListDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDataListDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.externalApis.MovieDBSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    private final MovieDBSummaryToMovieDataDTOMapper movieDBSummaryToMovieDataDTOMapper;

    public MovieDataDTO getMovieSummaryFromMovieDB(Long movieId) {
        MovieDBSummary movieDBSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
                MovieDBSummary.class
        );
        return movieDBSummaryToMovieDataDTOMapper.toDTO(movieDBSummary);
    }

    public MovieDataListDTO getMovieSummaryListFromMovieDB(MovieRatingIDListDTO movieRatingIDListDTO) {
        List<MovieDataDTO> movieDataDTOS = new ArrayList<>();
        try {
            movieRatingIDListDTO.getMovieRatingIds().forEach(movieId -> movieDataDTOS.add(this.getMovieSummaryFromMovieDB(movieId)));
            return new MovieDataListDTO(movieDataDTOS);
        } catch (HttpClientErrorException e) {
            // TODO: add log4j
            throw e;
        }
    }

}

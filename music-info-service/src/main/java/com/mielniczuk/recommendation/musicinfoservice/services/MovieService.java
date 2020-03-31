package com.mielniczuk.recommendation.musicinfoservice.services;

import com.mielniczuk.recommendation.musicinfoservice.mappers.MovieDBSummaryToMovieDTOMapper;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.externalApis.MovieDBSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Value("${api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    private final MovieDBSummaryToMovieDTOMapper movieDBSummaryToMovieDTOMapper;

    public MovieDTO getMovieSummaryFromMovieDB(Long movieId) {
        MovieDBSummary movieDBSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
                MovieDBSummary.class
        );
        return movieDBSummaryToMovieDTOMapper.toDTO(movieDBSummary);
    }

}

package com.mielniczuk.recommendation.musiccatalogservice.services;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieDataDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieDataListDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieRatingIDListDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieDataService {

    private final RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMovieDataListFallback")
    public MovieDataListDTO getMovieDataList(MovieRatingIDListDTO movieRatingIDListDTO) {
        return restTemplate.postForObject("http://music-info-service/movies/list/", movieRatingIDListDTO, MovieDataListDTO.class);
    }

    private MovieDataListDTO getMovieDataListFallback(MovieRatingIDListDTO movieRatingIDListDTO) {
        List<MovieDataDTO> movieDataDTOS = movieRatingIDListDTO.getMovieRatingIds()
                .stream()
                .map(ratingId -> new MovieDataDTO(ratingId, "Title not found", "Overview not found"))
                .collect(Collectors.toList());
        return new MovieDataListDTO(movieDataDTOS);
    }

}

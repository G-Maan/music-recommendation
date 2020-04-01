package com.mielniczuk.recommendation.musiccatalogservice.services;

import com.mielniczuk.recommendation.musiccatalogservice.mappers.CatalogMapper;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicCatalogService {

    @Qualifier("musicInfoWebClient")
    private final WebClient musicInfoWebClient;

    @Qualifier("ratingWebClient")
    private final WebClient ratingWebClient;

    private final RestTemplate restTemplate;

    private final CatalogMapper catalogMapper;

    public UserCatalogDTO getUserMusicCatalog(Long userId) {
        try {
            MovieRatingListDTO movieRatingListDTO = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, MovieRatingListDTO.class);
            UserCatalogDTO userCatalogDTO = new UserCatalogDTO();

            List<CatalogDTO> catalogDTOS = new ArrayList<>();

            MovieRatingIDListDTO movieRatingIDListDTO = new MovieRatingIDListDTO(movieRatingListDTO.getRatings().stream().map(MovieRatingDTO::getId).collect(Collectors.toList()));

            MovieDataListDTO movieDataListDTO = restTemplate.postForObject("http://music-info-service/movies/list/", movieRatingIDListDTO, MovieDataListDTO.class);

            movieDataListDTO.getMovieDataDTOS().forEach(movieDataDTO -> {
                Optional<MovieRatingDTO> movieRatingDTO = movieRatingListDTO.getRatings().stream().filter(movieRat -> movieRat.getId().equals(movieDataDTO.getId())).findFirst();
                catalogDTOS.add(movieRatingDTO.map(movieRat -> catalogMapper.toDTO(movieDataDTO, movieRat)).orElseThrow(NoSuchElementException::new));
            });

//          MusicDTO musicDTO = restTemplate.getForObject("http://music-info-service/music/" + ratingDTO.getId(), MusicDTO.class);
            userCatalogDTO.setCatalogDTOS(catalogDTOS);

            return userCatalogDTO;
        } catch (HttpClientErrorException e) {
            // TODO: add log4j
            throw e;
        }
/*        Flux<MusicDTO> musicDTOFlux = Flux.fromIterable(ratedMusic)
                .parallel()
                .runOn(Schedulers.elastic())
                .flatMap(this::getMusicInfo)
                .ordered(Comparator.comparingInt(MusicDTO::getId))
                .log();
//        musicDTOFlux.subscribe(System.out::println);

        Flux<RatingDTO> ratingDTOFlux = Flux.fromIterable(ratedMusic)
                .parallel()
                .runOn(Schedulers.elastic())
                .flatMap(this::getRating)
                .ordered(Comparator.comparingInt(RatingDTO::getId));
//        ratingDTOFlux.subscribe(System.out::println);*/

//        return Flux.zip(musicDTOFlux, ratingDTOFlux, (BiFunction<MusicDTO, RatingDTO, CatalogDTO>) CatalogDTO::new).zipWithIterable(ratedMusic, (catalog, rated) -> new CatalogDTO(rated, catalog));
    }

    private Mono<MusicDTO> getMusicInfo(int id) {
        return musicInfoWebClient.get()
                .uri("music/{musicId}", id)
                .retrieve()
                .bodyToMono(MusicDTO.class);
    }

    private Mono<MovieRatingDTO> getRating(int id) {
        return ratingWebClient.get()
                .uri("ratings/{ratingId}", id)
                .retrieve()
                .bodyToMono(MovieRatingDTO.class);
    }

}

package com.mielniczuk.recommendation.musiccatalogservice.resources;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class MusicCatalogResource {

    @Qualifier("musicInfoWebClient")
    private final WebClient musicInfoWebClient;

    @Qualifier("ratingWebClient")
    private final WebClient ratingWebClient;

    private final RestTemplate restTemplate;

    @GetMapping(path = "/{userId}")
    public UserCatalogDTO getCatalog(@PathVariable("userId") int userId) {

        RatingListDTO ratingListDTO = restTemplate.getForObject("http://ratings-data-service/ratings/users/" + userId, RatingListDTO.class);

        UserCatalogDTO userCatalogDTO = new UserCatalogDTO();

        List<CatalogDTO> catalogDTOS = new ArrayList<>();

        if (ratingListDTO != null) {
            catalogDTOS = ratingListDTO.getRatings().stream().map(ratingDTO -> {
//                MusicDTO musicDTO = restTemplate.getForObject("http://music-info-service/music/" + ratingDTO.getId(), MusicDTO.class);
                MovieDTO movieDTO = restTemplate.getForObject("http://music-info-service/movies/" + ratingDTO.getId(), MovieDTO.class);
                return new CatalogDTO(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getOverview(), ratingDTO.getValue());
            }).collect(Collectors.toList());
        }
        userCatalogDTO.setCatalogDTOS(catalogDTOS);

        return userCatalogDTO;
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

    public Mono<MusicDTO> getMusicInfo(int id) {
        return musicInfoWebClient.get()
                .uri("music/{musicId}", id)
                .retrieve()
                .bodyToMono(MusicDTO.class);
    }

    public Mono<RatingDTO> getRating(int id) {
        return ratingWebClient.get()
                .uri("ratings/{ratingId}", id)
                .retrieve()
                .bodyToMono(RatingDTO.class);
    }

}

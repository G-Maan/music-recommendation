package com.mielniczuk.recommendation.musiccatalogservice.resources;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.*;
import com.mielniczuk.recommendation.musiccatalogservice.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MusicCatalogResource {

    private CatalogService catalogService;

    @Qualifier("musicInfoWebClient")
    private final WebClient musicInfoWebClient;

    @Qualifier("ratingWebClient")
    private final WebClient ratingWebClient;

    private final RestTemplate restTemplate;

    public MusicCatalogResource(CatalogService catalogService,
                                WebClient musicInfoWebClient,
                                WebClient ratingWebClient,
                                RestTemplate restTemplate) {
        this.catalogService = catalogService;
        this.musicInfoWebClient = musicInfoWebClient;
        this.ratingWebClient = ratingWebClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/{userId}")
    public UserCatalogDTO getCatalog(@PathVariable("userId") int userId) {

        RatingListDTO ratingListDTO = restTemplate.getForObject("http://localhost:8083/ratings/users/" + userId, RatingListDTO.class);

        UserCatalogDTO userCatalogDTO = new UserCatalogDTO();

        List<CatalogDTO> catalogDTOS = new ArrayList<>();

        if (ratingListDTO != null) {
            catalogDTOS = ratingListDTO.getRatings().stream().map(ratingDTO -> {
                MusicDTO musicDTO = restTemplate.getForObject("http://localhost:8082/music/" + ratingDTO.getId(), MusicDTO.class);
                return new CatalogDTO(musicDTO.getId(), musicDTO.getName(), musicDTO.getDescription(), ratingDTO.getValue());
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

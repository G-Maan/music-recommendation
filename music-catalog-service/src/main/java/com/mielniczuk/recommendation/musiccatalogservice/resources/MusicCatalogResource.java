package com.mielniczuk.recommendation.musiccatalogservice.resources;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.CatalogDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MusicDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.RatingDTO;
import com.mielniczuk.recommendation.musiccatalogservice.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MusicCatalogResource {

    private CatalogService catalogService;

    @Qualifier("musicInfoWebClient")
    private final WebClient musicInfoWebClient;

    @Qualifier("ratingWebClient")
    private final WebClient ratingWebClient;

    public MusicCatalogResource(CatalogService catalogService,
                                WebClient musicInfoWebClient,
                                WebClient ratingWebClient) {
        this.catalogService = catalogService;
        this.musicInfoWebClient = musicInfoWebClient;
        this.ratingWebClient = ratingWebClient;
    }

    @GetMapping(path = "/{userId}")
    public Flux<CatalogDTO> getCatalog(@PathVariable("userId") int userId) {

        List<Integer> ratedMusic = Arrays.asList(
            1, 2, 3, 4
        );

        Flux<MusicDTO> musicDTOFlux = Flux.fromIterable(ratedMusic)
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
//        ratingDTOFlux.subscribe(System.out::println);

        return Flux.zip(musicDTOFlux, ratingDTOFlux, (m, r) -> new CatalogDTO(m, r)).zipWithIterable(ratedMusic, (catalog, rated) -> new CatalogDTO(rated, catalog));
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

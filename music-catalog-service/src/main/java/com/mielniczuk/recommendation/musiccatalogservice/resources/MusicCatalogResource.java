package com.mielniczuk.recommendation.musiccatalogservice.resources;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.CatalogDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.RatingDTO;
import com.mielniczuk.recommendation.musiccatalogservice.services.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MusicCatalogResource {

    private CatalogService catalogService;

    private final WebClient moviesWebClient = WebClient.builder()
            .baseUrl("http://localhost:8082/")
            .build();

    public MusicCatalogResource(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(path = "/{userId}")
    public List<CatalogDTO> getCatalog(@PathVariable("userId") int userId) {

        List<RatingDTO> ratingDTOList = Arrays.asList(
                new RatingDTO(1, 4),
                new RatingDTO(2, 9),
                new RatingDTO(3, 2),
                new RatingDTO(4, 8)
        );

        Flux<MovieDTO> movieDTOFlux = Flux.fromIterable(ratingDTOList)
                .parallel()
                .runOn(Schedulers.elastic())
                .flatMap(ratingDTO -> this.getMovie(ratingDTO.getId()))
                .ordered(Comparator.comparingInt(MovieDTO::getId));

        movieDTOFlux.subscribe(System.out::println);

        return ratingDTOList.stream().map(ratingDTO -> {

            return new CatalogDTO(1, "LOTR", "test desc", 9);
        }).collect(Collectors.toList());

    }

    public Flux<MovieDTO> getMovie(int id) {
        return moviesWebClient.get()
                .uri("movies/{movieId}", id)
                .retrieve()
                .bodyToFlux(MovieDTO.class);
    }

}

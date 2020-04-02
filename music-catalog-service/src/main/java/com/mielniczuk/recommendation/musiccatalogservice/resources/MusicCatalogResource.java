package com.mielniczuk.recommendation.musiccatalogservice.resources;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.*;
import com.mielniczuk.recommendation.musiccatalogservice.services.MusicCatalogService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    private final MusicCatalogService musicCatalogService;

    @GetMapping(path = "/{userId}")
    public UserCatalogDTO getCatalog(@PathVariable("userId") Long userId) {
        return musicCatalogService.getUserMusicCatalog(userId);
    }

}

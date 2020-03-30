package com.mielniczuk.recommendation.musiccatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MusicCatalogServiceApplication {

	@Bean(name = "musicInfoWebClient")
	public WebClient getMusicInfoWebClient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8082/")
				.build();
	}

	@Bean(name = "ratingWebClient")
	public WebClient getRatingWebClient() {
		return WebClient.builder()
				.baseUrl("http://localhost:8083/")
				.build();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MusicCatalogServiceApplication.class, args);
	}

}

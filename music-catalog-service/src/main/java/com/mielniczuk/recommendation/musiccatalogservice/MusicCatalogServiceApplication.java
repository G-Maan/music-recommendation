package com.mielniczuk.recommendation.musiccatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MusicCatalogServiceApplication {

	@Bean(name = "musicInfoWebClient")
	@LoadBalanced // server discovery + load balance
	public WebClient getMusicInfoWebClient() {
		return WebClient.builder()
				.baseUrl("http://music-info-service/")
				.build();
	}

	@Bean(name = "ratingWebClient")
	@LoadBalanced // server discovery + load balance
	public WebClient getRatingWebClient() {
		return WebClient.builder()
				.baseUrl("http://ratings-data-service/")
				.build();
	}

	@Bean
	@LoadBalanced // server discovery + load balance
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000); // timeout of 3s
		return new RestTemplate(clientHttpRequestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(MusicCatalogServiceApplication.class, args);
	}

}

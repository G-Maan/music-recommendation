package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MovieSummary {

    private Long id;

    private String title;

    private String overview;
}

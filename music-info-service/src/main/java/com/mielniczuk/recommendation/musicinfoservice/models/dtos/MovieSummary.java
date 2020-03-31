package com.mielniczuk.recommendation.musicinfoservice.models.dtos;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table
public class MovieSummary {

    private Long id;

    private String title;

    private String overview;

}

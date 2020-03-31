package com.mielniczuk.recommendation.musicinfoservice.models.externalApis;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table
public class MovieDBSummary {

    private Long id;

    private String title;

    private String overview;

}

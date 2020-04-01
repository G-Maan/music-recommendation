package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieRatingIDListDTO {

    private List<Long> movieRatingIds;

}

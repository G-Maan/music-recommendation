package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class RatingListDTO {

    public RatingListDTO(List<RatingDTO> ratings) {
        this.ratings = ratings;
    }

    private List<RatingDTO> ratings;
}

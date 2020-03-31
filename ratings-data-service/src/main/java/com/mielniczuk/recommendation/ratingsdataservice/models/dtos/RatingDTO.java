package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RatingDTO {

    private Long id;
    private int value;

}

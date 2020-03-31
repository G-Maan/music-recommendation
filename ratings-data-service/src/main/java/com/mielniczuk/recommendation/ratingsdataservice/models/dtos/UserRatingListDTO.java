package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingListDTO {

    private List<RatingDTO> ratings;

}

package com.mielniczuk.recommendation.ratingsdataservice.models.dtos;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;
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

    public RatingDTO(Rating rating) {
        this.id = rating.getId();
        this.value = rating.getValue();
    }

}

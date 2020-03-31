package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDTO {

    private int id;
    private String name;
    private String description;
    private int rating;

    public CatalogDTO(int id, CatalogDTO catalog) {
        this.id = id;
        this.name = catalog.getName();
        this.description = catalog.getDescription();
        this.rating = catalog.getRating();
    }

    public CatalogDTO(MusicDTO musicDTO, RatingDTO ratingDTO) {
        this.name = musicDTO.getName();
        this.description = musicDTO.getDescription();
        this.rating = ratingDTO.getValue();
    }
}

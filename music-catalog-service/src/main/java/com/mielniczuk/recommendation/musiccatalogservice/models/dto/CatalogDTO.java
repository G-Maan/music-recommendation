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

    private Long id;
    private String name;
    private String description;
    private int rating;

}

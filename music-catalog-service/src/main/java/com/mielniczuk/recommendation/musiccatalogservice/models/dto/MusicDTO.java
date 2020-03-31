package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MusicDTO {

    private int id;
    private String name;
    private String description;

}

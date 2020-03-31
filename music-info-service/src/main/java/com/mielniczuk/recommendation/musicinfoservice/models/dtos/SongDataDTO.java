package com.mielniczuk.recommendation.musicinfoservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SongDataDTO {

    private Long id;
    private String name;
    private String description;

}

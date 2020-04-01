package com.mielniczuk.recommendation.musicinfoservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDataListDTO {

    private List<MovieDataDTO> movieDataDTOS;

}

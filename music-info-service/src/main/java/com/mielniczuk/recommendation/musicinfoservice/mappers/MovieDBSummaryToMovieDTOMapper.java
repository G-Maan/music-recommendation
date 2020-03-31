package com.mielniczuk.recommendation.musicinfoservice.mappers;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.externalApis.MovieDBSummary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieDBSummaryToMovieDTOMapper {

    MovieDTO toDTO(MovieDBSummary movieDBSummary);

}

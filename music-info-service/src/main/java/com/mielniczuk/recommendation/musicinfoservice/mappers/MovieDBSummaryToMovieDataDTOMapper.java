package com.mielniczuk.recommendation.musicinfoservice.mappers;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MovieDataDTO;
import com.mielniczuk.recommendation.musicinfoservice.models.externalApis.MovieDBSummary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MovieDBSummaryToMovieDataDTOMapper {

    MovieDataDTO toDTO(MovieDBSummary movieDBSummary);

}

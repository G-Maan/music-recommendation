package com.mielniczuk.recommendation.ratingsdataservice.mappers;

import com.mielniczuk.recommendation.ratingsdataservice.models.Rating;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.RatingDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    Rating toEntity(Rating ratingDTO);

    RatingDTO toDTO(Rating rating);

    List<RatingDTO> toDTOList(List<Rating> ratings);

}

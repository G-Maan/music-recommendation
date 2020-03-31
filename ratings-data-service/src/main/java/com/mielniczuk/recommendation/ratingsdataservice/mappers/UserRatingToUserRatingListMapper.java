package com.mielniczuk.recommendation.ratingsdataservice.mappers;

import com.mielniczuk.recommendation.ratingsdataservice.models.UserRating;
import com.mielniczuk.recommendation.ratingsdataservice.models.dtos.UserRatingListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RatingMapper.class)
public interface UserRatingToUserRatingListMapper {

    @Mapping(target = "ratings", source = "ratings")
    UserRatingListDTO toDTO(UserRating userRating);

}

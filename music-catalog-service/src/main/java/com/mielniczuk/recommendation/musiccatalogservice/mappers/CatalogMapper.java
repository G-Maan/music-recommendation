package com.mielniczuk.recommendation.musiccatalogservice.mappers;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.CatalogDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieDataDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MusicDTO;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.MovieRatingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CatalogMapper {

    @Mapping(source = "rating.id", target = "id")
    @Mapping(source = "rating.value", target = "rating")
    @Mapping(source = "music.name", target = "name")
    @Mapping(source = "music.description", target = "description")
    CatalogDTO toDTO(MusicDTO music, MovieRatingDTO rating);

    @Mapping(source = "rating.id", target = "id")
    @Mapping(source = "rating.value", target = "rating")
    @Mapping(source = "movie.title", target = "name")
    @Mapping(source = "movie.overview", target = "description")
    CatalogDTO toDTO(MovieDataDTO movie, MovieRatingDTO rating);

}

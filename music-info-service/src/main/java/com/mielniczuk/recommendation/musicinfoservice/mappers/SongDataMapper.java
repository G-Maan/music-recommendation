package com.mielniczuk.recommendation.musicinfoservice.mappers;

import com.mielniczuk.recommendation.musicinfoservice.models.SongData;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.SongDataDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongDataMapper {

    SongDataDTO toDTO(SongData songData);

}

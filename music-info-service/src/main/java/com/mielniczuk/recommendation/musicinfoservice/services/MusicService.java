package com.mielniczuk.recommendation.musicinfoservice.services;

import com.mielniczuk.recommendation.musicinfoservice.mappers.SongDataMapper;
import com.mielniczuk.recommendation.musicinfoservice.models.SongData;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.SongDataDTO;
import com.mielniczuk.recommendation.musicinfoservice.repositories.SongDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final SongDataRepository songDataRepository;

    private final SongDataMapper songDataMapper;

    public SongDataDTO getMusic(Long musicId) {
        Optional<SongData> songInfo = this.songDataRepository.findById(musicId);
        return songInfo.map(songDataMapper::toDTO).orElseThrow(NoSuchElementException::new);
    }
}

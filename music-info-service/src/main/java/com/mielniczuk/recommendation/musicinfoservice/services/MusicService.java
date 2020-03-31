package com.mielniczuk.recommendation.musicinfoservice.services;

import com.mielniczuk.recommendation.musicinfoservice.models.Music;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MusicDTO;
import com.mielniczuk.recommendation.musicinfoservice.repositories.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicDTO getMusic(Long musicId) {
        Optional<Music> music = this.musicRepository.findById(musicId);
        if (music.isPresent()) {
           return new MusicDTO(music.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}

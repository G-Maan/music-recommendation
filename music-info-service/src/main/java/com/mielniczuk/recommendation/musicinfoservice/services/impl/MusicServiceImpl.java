package com.mielniczuk.recommendation.musicinfoservice.services.impl;

import com.mielniczuk.recommendation.musicinfoservice.models.Music;
import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MusicDTO;
import com.mielniczuk.recommendation.musicinfoservice.repositories.MusicRepository;
import com.mielniczuk.recommendation.musicinfoservice.services.MusicService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {

    private MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public MusicDTO getMusic(int musicId) {
        Optional<Music> music = this.musicRepository.findById(musicId);
        if (music.isPresent()) {
           return new MusicDTO(music.get());
        } else {
            throw new NoSuchElementException();
        }
    }
}

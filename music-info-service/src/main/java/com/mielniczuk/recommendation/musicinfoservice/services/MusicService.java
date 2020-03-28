package com.mielniczuk.recommendation.musicinfoservice.services;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MusicDTO;

public interface MusicService {

    public MusicDTO getMusic(int musicId);

}

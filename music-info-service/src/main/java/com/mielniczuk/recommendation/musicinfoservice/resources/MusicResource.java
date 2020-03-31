package com.mielniczuk.recommendation.musicinfoservice.resources;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.SongDataDTO;
import com.mielniczuk.recommendation.musicinfoservice.services.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicResource {

    private final MusicService musicService;

    @GetMapping("/{musicId}")
    public SongDataDTO getMusicInfo(@PathVariable("musicId") Long musicId) {
        return this.musicService.getMusic(musicId);
    }

}

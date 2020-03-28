package com.mielniczuk.recommendation.musicinfoservice.resources;

import com.mielniczuk.recommendation.musicinfoservice.models.dtos.MusicDTO;
import com.mielniczuk.recommendation.musicinfoservice.services.MusicService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
public class MusicResource {

    private final MusicService musicService;

    public MusicResource(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/{musicId}")
    public MusicDTO getMusicInfo(@PathVariable("musicId") int musicId) {
        System.out.println(musicId);
        return this.musicService.getMusic(musicId);
    }

}

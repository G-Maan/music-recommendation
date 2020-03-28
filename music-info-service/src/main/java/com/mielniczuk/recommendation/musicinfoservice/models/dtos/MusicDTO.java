package com.mielniczuk.recommendation.musicinfoservice.models.dtos;

import com.mielniczuk.recommendation.musicinfoservice.models.Music;

public class MusicDTO {

    private int id;
    private String name;
    private String description;

    public MusicDTO() {
    }

    public MusicDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public MusicDTO(Music music) {
        this.id = music.getId();
        this.name = music.getName();
        this.description = music.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

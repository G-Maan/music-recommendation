package com.mielniczuk.recommendation.musicinfoservice.models.dtos;

import com.mielniczuk.recommendation.musicinfoservice.models.Music;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MusicDTO {

    private Long id;
    private String name;
    private String description;

    public MusicDTO(Music music) {
        this.id = music.getId();
        this.name = music.getName();
        this.description = music.getDescription();
    }

}

package com.mielniczuk.recommendation.musicinfoservice.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "song_data")
@Data
@ToString
public class SongData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

}

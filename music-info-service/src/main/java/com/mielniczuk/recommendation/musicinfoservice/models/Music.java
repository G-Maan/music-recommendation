package com.mielniczuk.recommendation.musicinfoservice.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "music")
@Data
@ToString
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

}

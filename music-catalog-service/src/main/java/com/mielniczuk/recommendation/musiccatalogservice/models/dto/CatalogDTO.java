package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import com.mielniczuk.recommendation.musiccatalogservice.models.Catalog;

public class CatalogDTO {

    private int id;
    private String name;
    private String description;
    private int rating;

    public CatalogDTO() {
    }

    public CatalogDTO(int id, String name, String description, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public CatalogDTO(Catalog catalog) {
        this.id = catalog.getId();
        this.name = catalog.getName();
        this.description = catalog.getDescription();
        this.rating = catalog.getRating();
    }

    public CatalogDTO(int id, CatalogDTO catalog) {
        this.id = id;
        this.name = catalog.getName();
        this.description = catalog.getDescription();
        this.rating = catalog.getRating();
    }

    public CatalogDTO(MusicDTO musicDTO, RatingDTO ratingDTO) {
        this.name = musicDTO.getName();
        this.description = musicDTO.getDescription();
        this.rating = ratingDTO.getValue();
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

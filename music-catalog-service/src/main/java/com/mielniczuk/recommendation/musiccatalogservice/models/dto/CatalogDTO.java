package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import com.mielniczuk.recommendation.musiccatalogservice.models.Catalog;

public class CatalogDTO {

    private int id;
    private String name;
    private String desc;
    private int rating;

    public CatalogDTO() {
    }

    public CatalogDTO(int id, String name, String desc, int rating) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public CatalogDTO(Catalog catalog) {
        this.id = catalog.getId();
        this.name = catalog.getName();
        this.desc = catalog.getDescription();
        this.rating = catalog.getRating();
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

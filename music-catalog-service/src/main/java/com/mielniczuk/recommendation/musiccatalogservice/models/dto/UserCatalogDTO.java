package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import java.util.List;

public class UserCatalogDTO {

    private List<CatalogDTO> catalogDTOS;

    public List<CatalogDTO> getCatalogDTOS() {
        return catalogDTOS;
    }

    public void setCatalogDTOS(List<CatalogDTO> catalogDTOS) {
        this.catalogDTOS = catalogDTOS;
    }
}

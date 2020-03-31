package com.mielniczuk.recommendation.musiccatalogservice.models.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserCatalogDTO {

    private List<CatalogDTO> catalogDTOS;
}

package com.mielniczuk.recommendation.musiccatalogservice.services;

import com.mielniczuk.recommendation.musiccatalogservice.models.dto.CatalogDTO;
import org.springframework.stereotype.Service;

public interface CatalogService {

    public CatalogDTO getCatalog(int id);

}

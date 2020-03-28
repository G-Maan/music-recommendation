package com.mielniczuk.recommendation.musiccatalogservice.services.impl;

import com.mielniczuk.recommendation.musiccatalogservice.models.Catalog;
import com.mielniczuk.recommendation.musiccatalogservice.models.dto.CatalogDTO;
import com.mielniczuk.recommendation.musiccatalogservice.repositories.CatalogRepository;
import com.mielniczuk.recommendation.musiccatalogservice.services.CatalogService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    private CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public CatalogDTO getCatalog(int id) {
        Optional<Catalog> catalog = this.catalogRepository.findById(id);
        return catalog.isPresent() ? new CatalogDTO(catalog.get()) : null;
    }
}

package com.mielniczuk.recommendation.musiccatalogservice.repositories;

import com.mielniczuk.recommendation.musiccatalogservice.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
}

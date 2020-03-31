package com.mielniczuk.recommendation.musicinfoservice.repositories;

import com.mielniczuk.recommendation.musicinfoservice.models.SongData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongDataRepository extends JpaRepository<SongData, Long> {
}

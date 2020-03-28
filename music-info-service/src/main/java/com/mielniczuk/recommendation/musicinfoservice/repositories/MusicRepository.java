package com.mielniczuk.recommendation.musicinfoservice.repositories;

import com.mielniczuk.recommendation.musicinfoservice.models.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {
}

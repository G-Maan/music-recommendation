package com.mielniczuk.recommendation.ratingsdataservice.repositories;

import com.mielniczuk.recommendation.ratingsdataservice.models.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRatingRepository extends JpaRepository<UserRating, Integer> {
}

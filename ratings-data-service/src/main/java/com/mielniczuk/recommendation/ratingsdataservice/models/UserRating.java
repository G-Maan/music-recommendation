package com.mielniczuk.recommendation.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_rating")
@Data
@ToString
public class UserRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(
            mappedBy = "userRating",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<Rating> ratings = new ArrayList<>();

    public void addRating(Rating rating) {
        ratings.add(rating);
        rating.setUserRating(this);
    }

    public void removeRating(Rating rating) {
        ratings.remove(rating);
        rating.setUserRating(null);
    }
}

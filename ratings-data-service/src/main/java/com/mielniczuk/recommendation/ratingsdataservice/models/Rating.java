package com.mielniczuk.recommendation.ratingsdataservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "rating")
@Data
@ToString
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private UserRating userRating;

}

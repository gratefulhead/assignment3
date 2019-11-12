package com.epam.course.dataengeneering.assignment3.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String movieTitle;
    private Date titleYear;
    private String directorName;
    private String language;
    private String country;
    private Integer duration;
    private Double imdbScore;
    private String genres;
    private String plotKeywords;

    private String color;
    private Double aspectRatio;
    private String contentRating;
    private Long budget;
    private Long gross;
    private String movieImdbLink;
    private Integer facenumberInPoster;

    private String actor1Name;
    private Integer actor1FacebookLikes;
    private String actor2Name;
    private Integer actor2FacebookLikes;
    private String actor3Name;
    private Integer actor3FacebookLikes;

    private Integer numCriticForReviews;
    private Integer numUserForReviews;
    private Integer numVotedUsers;
    private Integer directorFacebookLikes;
    private Integer movieFacebookLikes;
    private String castTotalFacebookLikes;
}

package com.epam.course.dataengeneering.assignment3.data.repository;

import com.epam.course.dataengeneering.assignment3.data.model.Movie;
import com.epam.course.dataengeneering.assignment3.view.MovieProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT m.movieTitle as title, " +
            "m.actor1Name as actor1Name, " +
            "m.genres as genres, " +
            "m.imdbScore as imdbScore " +
            "from Movie m WHERE to_tsvector(m.movieTitle) @@ to_tsquery(:movieTitle) " +
            "and m.genres ~* :genres " +
            "ORDER BY imdbScore DESC", nativeQuery = true)
    List<MovieProperty> searchMovie(@Param("movieTitle") String movieTitle,
                                    @Param("genres") String genres);

}

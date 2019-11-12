package com.epam.course.dataengeneering.assignment3.data.mapper.impl;

import com.epam.course.dataengeneering.assignment3.data.mapper.ToEntityMapper;
import com.epam.course.dataengeneering.assignment3.data.model.Movie;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class CsvToEntityMapper implements ToEntityMapper {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy");
    private static final int COLUMNS_SIZE = 28;

    @Override
    @SneakyThrows
    public Movie map(List<String> entityData) {
        if (entityData.size() != COLUMNS_SIZE) {
            throw new IllegalArgumentException("Source columns size doesn't match with entity columns: " + entityData);
        }

        return Movie.builder()
                .color(entityData.get(0).trim())
                .directorName(entityData.get(1).trim())
                .numCriticForReviews(StringUtils.isNotBlank(entityData.get(2)) ? Integer.valueOf(entityData.get(2).trim()) : null)
                .duration(StringUtils.isNotBlank(entityData.get(3)) ? Integer.valueOf(entityData.get(3).trim()) : null)
                .directorFacebookLikes(StringUtils.isNotBlank(entityData.get(4)) ? Integer.valueOf(entityData.get(4).trim()) : null)
                .actor3FacebookLikes(StringUtils.isNotBlank(entityData.get(5)) ? Integer.valueOf(entityData.get(5).trim()) : null)
                .actor2Name(entityData.get(6))
                .actor1FacebookLikes(StringUtils.isNotBlank(entityData.get(7)) ? Integer.valueOf(entityData.get(7).trim()) : null)
                .gross(StringUtils.isNotBlank(entityData.get(8)) ? Long.valueOf(entityData.get(8).trim()) : null)
                .genres(entityData.get(9).trim())
                .actor1Name(entityData.get(10).trim())
                .movieTitle(entityData.get(11).trim())
                .numVotedUsers(StringUtils.isNotBlank(entityData.get(12)) ? Integer.valueOf(entityData.get(12).trim()) : null)
                .castTotalFacebookLikes(entityData.get(13).trim())
                .actor3Name(entityData.get(14).trim())
                .facenumberInPoster(StringUtils.isNotBlank(entityData.get(15)) ? Integer.valueOf(entityData.get(15).trim()) : null)
                .plotKeywords(entityData.get(16).trim())
                .movieImdbLink(entityData.get(17).trim())
                .numUserForReviews(StringUtils.isNotBlank(entityData.get(18)) ? Integer.valueOf(entityData.get(18).trim()) : null)
                .language(entityData.get(19).trim())
                .country(entityData.get(20).trim())
                .contentRating(entityData.get(21).trim())
                .budget(StringUtils.isNotBlank(entityData.get(22)) ? Long.valueOf(entityData.get(22).trim()) : null)
                .titleYear(StringUtils.isNotBlank(entityData.get(23)) ? DATE_FORMAT.parse(entityData.get(23).trim()) : null)
                .actor2FacebookLikes(StringUtils.isNotBlank(entityData.get(24)) ? Integer.valueOf(entityData.get(24).trim()) : null)
                .imdbScore(StringUtils.isNotBlank(entityData.get(25)) ? Double.valueOf(entityData.get(25).trim()) : null)
                .aspectRatio(StringUtils.isNotBlank(entityData.get(26)) ? Double.valueOf(entityData.get(26).trim()) : null)
                .movieFacebookLikes(StringUtils.isNotBlank(entityData.get(27)) ? Integer.valueOf(entityData.get(27).trim()) : null)
                .build();
    }
}

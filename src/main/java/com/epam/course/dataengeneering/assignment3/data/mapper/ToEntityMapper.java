package com.epam.course.dataengeneering.assignment3.data.mapper;

import com.epam.course.dataengeneering.assignment3.data.model.Movie;

import java.util.List;

@FunctionalInterface
public interface ToEntityMapper {
    Movie map(List<String> entityData);
}

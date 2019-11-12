package com.epam.course.dataengeneering.assignment3.data.mapper;

import java.util.List;

@FunctionalInterface
public interface ToColumnListMapper {
    List<String> map(String row);
}

package com.epam.course.dataengeneering.assignment3.data.mapper.impl;

import com.epam.course.dataengeneering.assignment3.data.mapper.ToColumnListMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CsvToColumnListMapper implements ToColumnListMapper {

    private static final String CSV_REGEX = "[^,\"]+|(\"[^\"]*\")|(?<=[^a-zA-Z0-9\\x7f-\\xff\\s .\"']|^)";
    private static final Pattern CSV_PATTERN = Pattern.compile(CSV_REGEX);

    @Override
    public List<String> map(String row) {
        final List<String> columnList = new ArrayList<>();
        final Matcher regexMatcher = CSV_PATTERN.matcher(row.replace("\"\"", ""));
        while (regexMatcher.find()) {
            final String next = regexMatcher.group();
            columnList.add(next);
        }
        return columnList;
    }
}

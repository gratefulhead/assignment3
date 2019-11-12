package com.epam.course.dataengeneering.assignment3.service;

import com.epam.course.dataengeneering.assignment3.data.mapper.ToColumnListMapper;
import com.epam.course.dataengeneering.assignment3.data.mapper.ToEntityMapper;
import com.epam.course.dataengeneering.assignment3.data.model.Movie;
import com.epam.course.dataengeneering.assignment3.data.provider.DataProvider;
import com.epam.course.dataengeneering.assignment3.data.repository.MovieRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:application.properties")
@Slf4j
public class DataInitializationService {

    @Value("${csv.batch.limit}")
    private Integer batchLimit;
    @Value("${csv.datasource.name}")
    private String dataSourceName;

    @Autowired
    private DataProvider dataProvider;
    @Autowired
    private ToColumnListMapper toColumnListMapper;
    @Autowired
    private ToEntityMapper toEntityMapper;
    @Autowired
    private MovieRepository movieRepository;

    @SneakyThrows
    public void process(){
        final Path path = Paths.get(ClassLoader.getSystemResource(dataSourceName).toURI());
        dataProvider.batchRead(path, batchLimit)
                .forEach(entities -> {
                    final Set<Movie> batch = entities
                            .map(toColumnListMapper::map).map(toEntityMapper::map).collect(Collectors.toSet());
                    movieRepository.saveAll(batch);
                    log.info("Saving in progress... " + batch.size() + " records persisted in batch.");
                });
    }

}

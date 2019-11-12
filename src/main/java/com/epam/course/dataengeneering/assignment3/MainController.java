package com.epam.course.dataengeneering.assignment3;


import com.epam.course.dataengeneering.assignment3.data.repository.MovieRepository;
import com.epam.course.dataengeneering.assignment3.view.MovieForm;
import com.epam.course.dataengeneering.assignment3.view.MovieProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public String main(Model model) {
        final MovieForm attributeValue = new MovieForm();
        attributeValue.setTitle("");
        model.addAttribute("movie", attributeValue);
        model.addAttribute("movies", new ArrayList<MovieProperty>());
        return "index";
    }

    @PostMapping("/search")
    public String searchMovie(@ModelAttribute("movie") MovieForm movie, Model model) {
        final List<MovieProperty> movieProperties =
                movieRepository.searchMovie(
                        formatTitleInput(movie.getTitle()),
                        formatGenresInput(movie.getGenres())
                );
        model.addAttribute("movies", movieProperties);
        return "index";
    }

    private String formatTitleInput(String value) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }

        return value.trim().replaceAll(" ", "+") + ":*";
    }

    private String formatGenresInput(String value) {
        if (StringUtils.isEmpty(value)) {
            return "";
        }
        final String result = StringUtils.trimAllWhitespace(value).replaceAll(",", "|");
        return ".*" + result + "*";
    }

}

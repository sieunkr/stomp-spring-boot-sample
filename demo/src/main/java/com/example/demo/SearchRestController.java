package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchRestController {

    private final MovieService movieService;

    public SearchRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public List<Movie> search() {
        return movieService.findAll();
    }

}

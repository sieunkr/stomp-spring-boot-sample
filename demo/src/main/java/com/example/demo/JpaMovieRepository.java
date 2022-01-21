package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Component
public class JpaMovieRepository implements MovieRepository {

    @Override
    public List<Movie> findAll() {

        //데이터베이스 연동 로직...

        List<Movie> movies = Arrays.asList(Movie.builder()
                .name("영화1").director("감독").rating(9.7f).build());

        return movies;
    }
}

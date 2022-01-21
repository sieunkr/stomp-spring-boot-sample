package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class MemoryMovieRepository implements MovieRepository {

    private final RestTemplate restTemplate;

    @Override
    public List<Movie> findAll() {


        restTemplate.exchange("naver.openapi...").

        List<Movie> movies = Arrays.asList(Movie.builder()
                .name("영화1").director("감독").rating(9.7f).build());

        return movies;
    }
}

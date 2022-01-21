package com.example.demo;

import lombok.Builder;
import lombok.Getter;

//도메인 엔티티.. (?)
@Getter
@Builder
public class Movie {

    private String name;
    private String director;    //감독
    private Float rating;       //평점

    public void changeName(String name) {
        this.name = name;
    }

}

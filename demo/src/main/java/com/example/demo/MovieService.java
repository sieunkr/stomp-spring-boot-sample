package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* 따로 공부해야할 리스트
    1. Bean 등록 방법 (스프링 컨텍스트가 관리할 수 있도록 등록해줌)
    2. 스프링 의존성 주입 방법
    3.

    다음 스터디 준비 사항
    1. 네이버 또는 카카오 오픈API 연동 가능하도록, 네이버(또는 카카오) 개발자센터에서 등록해오기
    (영화 검색, 책 검색, 쇼핑 검색..)
 */


/*

1. 스프링 컨텍스트에 Bean 을 등록해주는 방법
 첫번째 - ComponetScan, @Component 어노테이션 사용
 @Component, @Service, @Repository, @RestCOntroller, @Controller..
 두번째 - Bean 어노테이션 & COnfiguration 어노테이션 사용

2. 스프링 의존성 주입 방법
   1. @Autowired, 2. 생성자 주입, 3. 셋터주입, 4.Lombok @RequiredArgsConstructor

 */

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
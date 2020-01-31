package edu.pasudo123.study.externalopenapi.moviedb.controller;

import edu.pasudo123.study.externalopenapi.moviedb.service.MovieDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieDbController {

    private final MovieDbService movieDbService;

    @GetMapping("/auth")
    public String authenticate() {

        return movieDbService.authProcess();
    }
}

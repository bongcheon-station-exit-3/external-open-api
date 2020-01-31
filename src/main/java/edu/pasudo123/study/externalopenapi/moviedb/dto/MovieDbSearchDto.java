package edu.pasudo123.study.externalopenapi.moviedb.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieDbSearchDto {

    @Getter
    public static class Request {
        private String title;
    }

    @Getter
    public static class Response {

    }
}

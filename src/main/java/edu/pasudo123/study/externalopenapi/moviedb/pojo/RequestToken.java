package edu.pasudo123.study.externalopenapi.moviedb.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class RequestToken implements Serializable {

    private String success;
    private String expires_at;
    private String request_token;

}

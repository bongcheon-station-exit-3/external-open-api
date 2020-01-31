package edu.pasudo123.study.externalopenapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "moviedb")
public class MovieDbConfiguration {

    private String apiKeyV3;
    private String apiKeyV4;
    private Api api;

    @Setter
    @Getter
    public static class Api {
        private String requestTokenUrl;
        private String sessionIdUrl;
    }
}

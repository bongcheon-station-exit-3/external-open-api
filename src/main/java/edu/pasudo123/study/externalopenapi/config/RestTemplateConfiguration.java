package edu.pasudo123.study.externalopenapi.config;

import edu.pasudo123.study.externalopenapi.interceptor.RequestResponseLoggingInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate() {

        final RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
//        final RestTemplate restTemplate = restTemplateBuilder.build();

        return restTemplateBuilder
                .additionalInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()))
                .build();

//        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
//
//        return restTemplate;
    }
}

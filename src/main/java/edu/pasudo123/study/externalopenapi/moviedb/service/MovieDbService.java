package edu.pasudo123.study.externalopenapi.moviedb.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.pasudo123.study.externalopenapi.config.MovieDbConfiguration;
import edu.pasudo123.study.externalopenapi.moviedb.pojo.RequestToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieDbService {

    private final ObjectMapper mapper;
    private final MovieDbConfiguration movieDbConfiguration;
    private final RestTemplate restTemplate;

    /**
     * request token 획득 이후 session 획득.
     */
    public String authProcess() {

        final RequestToken requestToken = restTemplate.getForObject(
                movieDbConfiguration.getApi().getRequestTokenUrl(),
                RequestToken.class,
                movieDbConfiguration.getApiKeyV3()
        );


        assert requestToken != null;
        final String requestBody = "{\"request_token\": \"" + requestToken.getRequest_token() + "\"}";

        final String session = restTemplate.postForObject(
                movieDbConfiguration.getApi().getSessionIdUrl(),
                requestBody,
                String.class,
                movieDbConfiguration.getApiKeyV3()
        );

        log.debug("request-token : {}", requestToken);
        log.debug("session : {}", session);

        return null;
    }
}

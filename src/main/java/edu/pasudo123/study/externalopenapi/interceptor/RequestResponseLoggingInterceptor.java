package edu.pasudo123.study.externalopenapi.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

// https://objectpartners.com/2018/03/01/log-your-resttemplate-request-and-response-without-destroying-the-body/
@Slf4j
public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        this.logRequest(request, body);

        final ClientHttpResponse response = execution.execute(request, body);

        this.logResponse(response);

        return response;
    }

    private void logRequest(final HttpRequest request, byte[] body) throws IOException {

        if(!log.isDebugEnabled()) {
            return;
        }

        log.debug("\n[Request] Begin ===========================================");
        log.debug("URI                       : {}", request.getURI());
        log.debug("METHOD                    : {}", request.getMethod());
        log.debug("HEADERS                   : {}", request.getHeaders());
        log.debug("Request-Body              : {}", new String(body, StandardCharsets.UTF_8));
        log.debug("Request End   ===========================================");
    }

    private void logResponse(final ClientHttpResponse response) throws IOException{

        if(!log.isDebugEnabled()){
            return;
        }

        log.debug("\n[Response] Begin ===========================================");
        log.debug("Status Code          : {}", response.getStatusCode());
        log.debug("Status Text          : {}", response.getStatusText());
        log.debug("Headers              : {}", response.getHeaders());
        log.debug("Response Body        : {}", response.getBody());
        log.debug("Response End   ===========================================");
    }
}

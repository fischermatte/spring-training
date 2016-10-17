package org.fischermatte.training.spring.mvc.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    @Value("${server.port}")
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    public void doSomeRest() {
        String baseUrl = "http://localhost:" + port;
        restTemplate.getForObject(baseUrl +  "/api/hello",String.class);
        restTemplate.getForObject(baseUrl + "/api/hello?name=Hase",String.class);
        restTemplate.getForObject(baseUrl + "/api/hello?name=Maus",String.class);
    }
}

package org.fischermatte.training.spring.mvc;

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
        restTemplate.getForObject(baseUrl +  "/hello",String.class);
        restTemplate.getForObject(baseUrl + "/hello?name=Hase",String.class);
        restTemplate.getForObject(baseUrl + "/hello?name=Maus",String.class);
    }
}

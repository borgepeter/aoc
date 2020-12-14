package com.pborge.advent.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class WebRepository {
    private final String WEB_URL = "https://adventofcode.com/2020/day/";
    private final String INPUT = "/input";
    private final String COOKIE = "Cookie";
    @Value("${sessionId}")
    private String sessionId;

    public String getData(int adventDay) {
        String url = WEB_URL + adventDay + INPUT;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(COOKIE, "session="+ sessionId);
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return responseEntity.getBody();
    }
}

package com.sda.spring.boot.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyRatioUpdaterService {

    public JsonExternalRestResponse getResponse(String base){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonExternalRestResponse> response = restTemplate.getForEntity("http://api.fixer.io/latest?base=" + base, JsonExternalRestResponse.class);
        return response.getBody();
    }
}

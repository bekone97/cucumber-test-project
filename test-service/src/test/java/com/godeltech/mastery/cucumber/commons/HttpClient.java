package com.godeltech.mastery.cucumber.commons;

import com.godeltech.mastery.model.Cucumber;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class HttpClient {

    private final String SERVER_URL = "http://localhost:";
    private final String CUCUMBERS_ENDPOINTS= "/cucumbers";

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    private String cucumbersEndpoints(){
        return SERVER_URL+port+CUCUMBERS_ENDPOINTS;
    }

    public ResponseEntity post(Object object){
        return restTemplate.postForObject(cucumbersEndpoints(),object,ResponseEntity.class);
    }

    public ResponseEntity<String> get(){
        var resp= restTemplate.getForEntity(cucumbersEndpoints(),String.class);
        return resp;
    }

    public ResponseEntity<Cucumber> getCucumber(){
        return restTemplate.getForEntity(cucumbersEndpoints()+"/cucumber",Cucumber.class);
    }
}

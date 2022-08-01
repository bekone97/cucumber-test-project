package com.godeltech.mastery.cucumber.basics;

import com.godeltech.mastery.cucumber.commons.HttpClient;
import com.godeltech.mastery.model.Cucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

public class CucumberControllerSteps {
    @Autowired
    private HttpClient httpClient;
    private ResponseEntity<String> response;
    private ResponseEntity<Cucumber> cucumberResponse;

    @When("^the client calls /cucumbers$")
    public void theClientCalls(){
        response= httpClient.get();
        System.out.println(response);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int statusCode){
        System.out.println(statusCode);
        assertTrue(statusCode==response.getStatusCode().value());
    }

    @Then("^the client receives from /cucumbers/cucumber status code of (\\d+)$")
    public void theClientReceivesFromCucumbersCucumberStatusCodeOf(int statusCode){
        System.out.println(statusCode);
        assertTrue(statusCode==cucumberResponse.getStatusCode().value());
    }

    @And("the client receives a response {string}")
    public void theClientReceivesResponse(String expectedString){
        assertEquals(expectedString,response.getBody());
    }

    @And("the client receives a ResponseEntity")
    public void theClientReceivesResponseEntity(){
        assertEquals(Cucumber.builder()
                .age(21)
                .name("cucu")
                .build(),cucumberResponse.getBody());
    }

    @When("^the client calls /cucumbers/cucumber")
    public void theClientCallsCucumbersCucumber(){
        cucumberResponse=httpClient.getCucumber();
    }

}

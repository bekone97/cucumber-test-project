package com.godeltech.mastery.controller;

import com.godeltech.mastery.model.Cucumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cucumbers")
public class CucumberController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getCall(){
        return "Hello cucumbers";
    }

    @GetMapping("/cucumber")
    @ResponseStatus(HttpStatus.OK)
    public Cucumber getCucumber(){
        return Cucumber.builder()
                .age(21)
                .name("cucu")
                .build();
    }
}

package com.godeltech.mastery.cucumber.commons;

import com.godeltech.mastery.ApplicationServiceApplication;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@CucumberOptions(plugin = "pretty",features = "src/test/resources/features")
@CucumberContextConfiguration
@SpringBootTest(classes = ApplicationServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {
}

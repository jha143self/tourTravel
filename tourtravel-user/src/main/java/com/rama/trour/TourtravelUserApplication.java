package com.rama.trour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.rama.trour.application.DevelopmentProfileConfiguration;

@SpringBootApplication
@PropertySource("userservice.properties")
public class TourtravelUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                new Object[]{
                        TourtravelUserApplication.class,
                        DevelopmentProfileConfiguration.class}
                , args);
    }
}

package com.orleans.univ.microservices.servicecatalogue;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableRabbit
@SpringBootApplication
public class ServicecatalogueApplication {

    public static void main(String[] args) {

        SpringApplication.run(ServicecatalogueApplication.class, args);
    }

}

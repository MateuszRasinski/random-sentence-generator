package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RandomSentenceGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomSentenceGeneratorApplication.class, args);
    }
}


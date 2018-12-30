package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.web.bind.annotation.GetMapping;

interface RandomWordGeneratorClient {

    @GetMapping("/word")
    String getWord();
}

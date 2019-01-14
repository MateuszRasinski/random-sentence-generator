package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
class ObjectGenerator {
    private final RandomObjectGeneratorClient randomObjectGeneratorClient;
    private final FallbackWords fallbackWords;

    ObjectGenerator(RandomObjectGeneratorClient randomObjectGeneratorClient,
                    FallbackWords fallbackWords) {
        this.randomObjectGeneratorClient = randomObjectGeneratorClient;
        this.fallbackWords = fallbackWords;
    }

    @HystrixCommand(fallbackMethod = "fallbackObject")
    String generateObject() {
        return randomObjectGeneratorClient.getWord();
    }

    @HystrixCommand
    private String fallbackObject() {
        return fallbackWords.getObject();
    }
}

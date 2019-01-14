package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
class PredicateGenerator {
    private final RandomPredicateGeneratorClient randomPredicateGeneratorClient;
    private final FallbackWords fallbackWords;

    PredicateGenerator(RandomPredicateGeneratorClient randomPredicateGeneratorClient,
                       FallbackWords fallbackWords) {
        this.randomPredicateGeneratorClient = randomPredicateGeneratorClient;
        this.fallbackWords = fallbackWords;
    }

    @HystrixCommand(fallbackMethod = "fallbackPredicate")
    String generatePredicate() {
        return randomPredicateGeneratorClient.getWord();
    }

    @HystrixCommand
    private String fallbackPredicate() {
        return fallbackWords.getPredicate();
    }
}

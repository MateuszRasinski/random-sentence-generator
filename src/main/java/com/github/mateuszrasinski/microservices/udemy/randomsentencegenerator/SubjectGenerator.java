package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
class SubjectGenerator {
    private final RandomSubjectGeneratorClient randomSubjectGeneratorClient;
    private final FallbackWords fallbackWords;

    SubjectGenerator(RandomSubjectGeneratorClient randomSubjectGeneratorClient,
                     FallbackWords fallbackWords) {
        this.randomSubjectGeneratorClient = randomSubjectGeneratorClient;
        this.fallbackWords = fallbackWords;
    }

    @HystrixCommand(fallbackMethod = "fallbackSubject")
    String generateSubject() {
        return randomSubjectGeneratorClient.getWord();
    }

    @HystrixCommand
    private String fallbackSubject() {
        return fallbackWords.getSubject();
    }
}

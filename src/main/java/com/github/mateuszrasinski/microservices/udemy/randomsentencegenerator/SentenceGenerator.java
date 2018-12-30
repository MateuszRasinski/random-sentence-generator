package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.stereotype.Service;

@Service
class SentenceGenerator {

    private final RandomSubjectGeneratorClient randomSubjectGeneratorClient;
    private final RandomPredicateGeneratorClient randomPredicateGeneratorClient;
    private final RandomObjectGeneratorClient randomObjectGeneratorClient;

    SentenceGenerator(RandomSubjectGeneratorClient randomSubjectGeneratorClient,
                      RandomPredicateGeneratorClient randomPredicateGeneratorClient,
                      RandomObjectGeneratorClient randomObjectGeneratorClient) {
        this.randomSubjectGeneratorClient = randomSubjectGeneratorClient;
        this.randomPredicateGeneratorClient = randomPredicateGeneratorClient;
        this.randomObjectGeneratorClient = randomObjectGeneratorClient;
    }

    String generateSentence() {
        return String.format("%s %s %s.",
                randomSubjectGeneratorClient.getWord(),
                randomPredicateGeneratorClient.getWord(),
                randomObjectGeneratorClient.getWord());
    }
}

package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.stereotype.Service;

@Service
class SentenceGenerator {

    private final PredicateGenerator predicateGenerator;
    private final ObjectGenerator objectGenerator;
    private final SubjectGenerator subjectGenerator;

    SentenceGenerator(SubjectGenerator subjectGenerator,
                      PredicateGenerator predicateGenerator,
                      ObjectGenerator objectGenerator) {
        this.predicateGenerator = predicateGenerator;
        this.objectGenerator = objectGenerator;
        this.subjectGenerator = subjectGenerator;
    }

    String generateSentence() {
        return String.format("%s %s %s.",
                subjectGenerator.generateSubject(),
                predicateGenerator.generatePredicate(),
                objectGenerator.generateObject());
    }
}

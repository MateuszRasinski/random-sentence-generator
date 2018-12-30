package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/sentence")
class SentenceController {

    private final SentenceGenerator sentenceGenerator;

    SentenceController(SentenceGenerator sentenceGenerator) {
        this.sentenceGenerator = sentenceGenerator;
    }

    @GetMapping
    String getSentence() {
        return String.format(
                "<h3>Sentences:</h3>"
                        + "%s<br/>"
                        + "%s<br/>"
                        + "%s<br/>"
                        + "%s<br/>",
                sentenceGenerator.generateSentence(),
                sentenceGenerator.generateSentence(),
                sentenceGenerator.generateSentence(),
                sentenceGenerator.generateSentence()
        );
    }
}

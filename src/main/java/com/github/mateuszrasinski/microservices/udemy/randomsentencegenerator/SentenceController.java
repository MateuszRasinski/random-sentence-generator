package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/sentence")
class SentenceController {

    private final RestTemplate restTemplate;

    SentenceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String getSentence() {
        return String.format("%s %s %s",
                getWord("random-subject-generator"),
                getWord("random-predicate-generator"),
                getWord("random-object-generator"));
    }

    private String getWord(String serviceId) {
        return restTemplate.getForObject(String.format("http://%s/word", serviceId), String.class);
    }
}

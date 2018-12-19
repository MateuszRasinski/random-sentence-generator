package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/sentence")
class SentenceController {

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    SentenceController(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    String getSentence() {
        return String.format("%s %s %s",
                getWord("random-subject-generator"),
                getWord("random-predicate-generator"),
                getWord("random-object-generator"));
    }

    private String getWord(String applicationName) {
        return discoveryClient.getInstances(applicationName)
                              .stream()
                              .findAny()
                              .map(ServiceInstance::getUri)
                              .map(uri -> restTemplate.getForObject(uri.resolve("/word"), String.class))
                              .orElse("");
    }
}

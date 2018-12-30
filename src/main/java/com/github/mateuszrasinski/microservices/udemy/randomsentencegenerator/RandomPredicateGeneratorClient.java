package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("random-predicate-generator")
interface RandomPredicateGeneratorClient extends RandomWordGeneratorClient {
}

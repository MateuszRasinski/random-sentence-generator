package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("random-object-generator")
interface RandomObjectGeneratorClient extends RandomWordGeneratorClient {
}

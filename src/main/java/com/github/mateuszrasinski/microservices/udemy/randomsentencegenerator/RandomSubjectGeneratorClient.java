package com.github.mateuszrasinski.microservices.udemy.randomsentencegenerator;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("random-subject-generator")
interface RandomSubjectGeneratorClient extends RandomWordGeneratorClient {
}

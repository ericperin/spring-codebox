package com.eperin.codebox

import io.micrometer.observation.ObservationRegistry
import io.micrometer.observation.aop.ObservedAspect
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableFeignClients
class CodeboxApplication

fun main(args: Array<String>) {
	runApplication<CodeboxApplication>(*args)
}

@Bean
fun observedAspect(observationRegistry: ObservationRegistry?): ObservedAspect {
	return ObservedAspect(observationRegistry!!)
}
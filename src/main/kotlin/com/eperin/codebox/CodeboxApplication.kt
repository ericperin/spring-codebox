package com.eperin.codebox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CodeboxApplication

fun main(args: Array<String>) {
    runApplication<CodeboxApplication>(*args)
}

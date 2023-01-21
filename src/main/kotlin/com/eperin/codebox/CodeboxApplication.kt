package com.eperin.codebox

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodeboxApplication

fun main(args: Array<String>) {
	runApplication<CodeboxApplication>(*args)
}

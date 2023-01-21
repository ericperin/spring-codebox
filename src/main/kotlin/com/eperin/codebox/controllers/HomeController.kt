package com.eperin.codebox.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
@RestController
class HomeController {
    var logger: Logger = LoggerFactory.getLogger(HomeController::class.java)

    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String? {
        logger.info("Log to INFO")
        logger.error("Log to ERRO")
        return String.format("Hello %s!", name)
    }
}
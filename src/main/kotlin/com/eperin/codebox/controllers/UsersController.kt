package com.eperin.codebox.controllers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UsersController {
    var logger: Logger = LoggerFactory.getLogger(UsersController::class.java)

    @GetMapping
    fun getAll(): ResponseEntity<String> {
        logger.info("deu bom {} - {}", "OK")

        return ResponseEntity.ok("Hello World!");
    }
}
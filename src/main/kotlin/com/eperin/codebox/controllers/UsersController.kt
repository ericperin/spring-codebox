package com.eperin.codebox.controllers

import com.eperin.codebox.services.UserService
import com.eperin.codebox.services.dtos.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UsersController {
    var logger: Logger = LoggerFactory.getLogger(UsersController::class.java)

    @Autowired
    private val userService: UserService? = null

    @GetMapping
    fun getAll(): ResponseEntity<List<Result>> {
        val result = userService!!.getAll()
        logger.info("Success!")

        return ResponseEntity.ok(result.results)
    }
}
package com.eperin.codebox.controllers

import com.eperin.codebox.dtos.CreateUserDto
import com.eperin.codebox.exceptions.NotFoundException
import com.eperin.codebox.services.interfaces.PlaceHolderService
import com.eperin.codebox.services.interfaces.ProductService
import com.eperin.codebox.services.interfaces.RandomUserService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("users")
class UsersController {
    var logger: Logger = LoggerFactory.getLogger(UsersController::class.java)

    @Autowired
    private val userService: RandomUserService? = null

    @Autowired
    private val productService: ProductService? = null

    @Autowired
    private val placeHolderService: PlaceHolderService? = null

    @GetMapping
    fun getAll(): Any {
        return try {
            val users = userService!!.getAll()
            val products = productService!!.getAll()
//            Thread.sleep(Random().nextLong(10000L)) // simulates latency
            val places = placeHolderService!!.getAll()
            logger.info(
                "{} users, {} products and {} places",
                users.results.count(),
                products.products.count(),
                places.count()
            )

            ResponseEntity.ok(users.results)

        } catch (e: Exception) {
            logger.error("Ops", e)

            ResponseEntity.internalServerError()
        }
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Int): Any {
        logger.info("Id: {}", id)

        if (id == 2) throw NotFoundException("User not found")
        return ResponseEntity.badRequest().body(null)
    }


    @PostMapping
    fun create(@Valid @RequestBody model: CreateUserDto): Any {
        logger.info("User: {}", model.name)
        val location = URI.create(String.format("/users/%s", model.name))

        return ResponseEntity.created(location).body(null)
    }
}
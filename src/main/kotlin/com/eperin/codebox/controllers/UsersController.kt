package com.eperin.codebox.controllers

import com.eperin.codebox.services.PlaceHolderService
import com.eperin.codebox.services.ProductService
import com.eperin.codebox.services.UserService
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
}
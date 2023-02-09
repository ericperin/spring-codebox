package com.eperin.codebox.services

import com.eperin.codebox.services.interfaces.RandomUserService

class UserService(
    private val userService: RandomUserService,
) {
    fun getAll(): Number {
        val result = userService.getAll()
        return result.results.size
    }
}
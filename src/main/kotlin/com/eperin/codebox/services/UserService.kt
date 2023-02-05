package com.eperin.codebox.services

import com.eperin.codebox.services.dtos.UserDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.randomuser}", name = "randomuser")
interface UserService {
    @RequestMapping(method = [RequestMethod.GET], value = ["api"], consumes = ["application/json"])
    fun getAll(): UserDto
}
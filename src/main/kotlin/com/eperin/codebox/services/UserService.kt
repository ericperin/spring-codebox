package com.eperin.codebox.services

import com.eperin.codebox.services.dtos.UserDto
import io.micrometer.observation.annotation.Observed
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.randomuser}", name = "randomuser")
interface UserService {
    @Observed(
        name = "user.all",
        contextualName = "getting-user-all"
    )
    @RequestMapping(method = [RequestMethod.GET], value = ["api"], consumes = ["application/json"])
    fun getAll(): UserDto
}
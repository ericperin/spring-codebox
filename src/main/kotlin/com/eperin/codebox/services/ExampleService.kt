package com.eperin.codebox.services

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.example}", name = "example")
interface ExampleService {
    @RequestMapping(method = [RequestMethod.GET], value = ["wiremock"], consumes = ["application/json"])
    fun get(): String?
}
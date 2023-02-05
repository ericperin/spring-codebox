package com.eperin.codebox.services

import com.eperin.codebox.services.dtos.DummyDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.dummyjson}", name = "dummyjson")
interface ProductService {
    @RequestMapping(method = [RequestMethod.GET], value = ["products"], consumes = ["application/json"])
    fun getAll(): DummyDto
}
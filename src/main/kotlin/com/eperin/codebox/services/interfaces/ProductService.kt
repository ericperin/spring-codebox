package com.eperin.codebox.services.interfaces

import com.eperin.codebox.services.dtos.DummyDto
import io.micrometer.observation.annotation.Observed
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.dummyjson}", name = "dummyjson")
interface ProductService {
    @Observed(
        name = "product.all",
        contextualName = "getting-product-all"
    )
    @RequestMapping(method = [RequestMethod.GET], value = ["products"], consumes = ["application/json"])
    fun getAll(): DummyDto
}
package com.eperin.codebox.services

import com.eperin.codebox.services.dtos.PlaceHolderDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.placeHolder}", name = "placeHolder")
interface PlaceHolderService {
    @RequestMapping(method = [RequestMethod.GET], value = ["todos"], consumes = ["application/json"])
    fun getAll(): List<PlaceHolderDto>
}
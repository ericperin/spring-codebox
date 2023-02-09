package com.eperin.codebox.services.interfaces

import com.eperin.codebox.services.dtos.PlaceHolderDto
import io.micrometer.observation.annotation.Observed
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "\${feign.services.placeHolder}", name = "placeHolder")
interface PlaceHolderService {
    @Observed(
        name = "place.all",
        contextualName = "getting-place-all"
    )
    @RequestMapping(method = [RequestMethod.GET], value = ["todos"], consumes = ["application/json"])
    fun getAll(): List<PlaceHolderDto>
}
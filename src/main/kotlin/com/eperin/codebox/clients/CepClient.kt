package com.eperin.codebox.clients

import com.eperin.codebox.dtos.AddressDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
interface CepClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["{cep}/json"], consumes = ["application/json"])
    fun buscaEnderecoPorCep(@PathVariable("cep") cep: String?): AddressDto?
}
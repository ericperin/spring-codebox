package com.eperin.codebox.controllers

import com.eperin.codebox.clients.CepClient
import com.eperin.codebox.dtos.AddressDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {
    var logger: Logger = LoggerFactory.getLogger(HomeController::class.java)

    @Autowired
    private val cepService: CepClient? = null

    @GetMapping("/cep/{cep}")
    fun getCep(@PathVariable cep: String?): ResponseEntity<AddressDto?>? {
        val endereco: AddressDto? = cepService?.buscaEnderecoPorCep(cep)
        return if (endereco != null) ResponseEntity.ok().body<AddressDto?>(endereco) else ResponseEntity.notFound()
            .build<AddressDto>()
    }

    @GetMapping("/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String? {
        logger.info("Log to INFO")
        logger.error("Log to ERRO")
        return String.format("Hello %s!", name)
    }
}
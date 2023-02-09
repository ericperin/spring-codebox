package com.eperin.codebox.controllers

import com.eperin.codebox.services.interfaces.CepService
import com.eperin.codebox.dtos.AddressDto
import com.eperin.codebox.services.interfaces.ExampleService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("adresses")
class HomeController {
    var logger: Logger = LoggerFactory.getLogger(HomeController::class.java)

    @Autowired
    private val cepService: CepService? = null
    @Autowired
    private val exampleService: ExampleService? = null

    @GetMapping("{cep}")
    fun getCep(@PathVariable cep: String?): ResponseEntity<AddressDto?>? {
        val endereco: AddressDto? = cepService?.buscaEnderecoPorCep(cep)
        return if (endereco != null) ResponseEntity.ok().body<AddressDto?>(endereco) else ResponseEntity.notFound()
            .build<AddressDto>()
    }

    @GetMapping
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String?): String? {
        val result = exampleService?.get()
        logger.info("deu bom {} - {}", result, name)
        return String.format("Hello %s!", name)
    }

    @GetMapping("/error/{msg}")
    fun error(@PathVariable msg: String?): ResponseEntity.BodyBuilder {
        try {
            throw Exception("Ops")
        } catch (e: Exception){
            logger.error("deu ruim {}", msg, e)
        }
        return ResponseEntity.ok()
    }
}
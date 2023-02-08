package com.eperin.codebox.dtos

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUserDto(
    @field:NotNull
    @field:NotEmpty
    @field:Size(min = 4, max = 100)
    val name: String?,

    @field:NotEmpty
    @field:NotNull
    @field:Size(min = 11, max = 11)
    val cpf: String?,

    @field:NotNull
    val cityId: Int?,

    val mother: String?,
)
package com.eperin.codebox.dtos

import java.time.LocalDateTime

data class ErrorDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val errors: HashMap<String, String?>?,
    val message: String?,
)

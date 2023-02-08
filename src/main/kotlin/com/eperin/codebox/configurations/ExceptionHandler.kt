package com.eperin.codebox.configurations

import com.eperin.codebox.dtos.ErrorDto
import com.eperin.codebox.exceptions.NotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex: NotFoundException, request: HttpServletRequest): ErrorDto {
        return ErrorDto(
            status = HttpStatus.NOT_FOUND.value(),
            message = ex.message,
            errors = null
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(ex: MethodArgumentNotValidException, request: HttpServletRequest): ErrorDto {
        val errors = HashMap<String, String?>()
        ex.bindingResult.fieldErrors.forEach{
            e -> errors[e.field] = e.defaultMessage
        }
        return ErrorDto(
            status = HttpStatus.BAD_REQUEST.value(),
            message = "Invalid fields",
            errors = errors
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(ex: Exception, request: HttpServletRequest): ErrorDto {
        return ErrorDto(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = ex.message,
            errors = null
        )
    }
}
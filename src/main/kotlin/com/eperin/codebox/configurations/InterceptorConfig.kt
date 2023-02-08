package com.eperin.codebox.configurations

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class InterceptorConfig : HandlerInterceptor {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
//        MDC.put("requestId", UUID.randomUUID().toString())
        return true
    }

    override fun afterCompletion(
        request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?
    ) {
//        MDC.remove("requestId")
    }
}
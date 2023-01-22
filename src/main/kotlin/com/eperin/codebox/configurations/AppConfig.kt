package com.eperin.codebox.configurations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class AppConfig : WebMvcConfigurer {
    @Autowired
    lateinit var config: InterceptorConfig

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(config)
    }
}
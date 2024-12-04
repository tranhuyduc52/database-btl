package com.example.database.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
<<<<<<< HEAD
                .allowedMethods("*")
=======
                .allowedMethods("GET","POST","PUT","PATCH","DELETE","OPTIONS")
>>>>>>> f25386567cdf62103ce5812c79e2bd89a9d783b1
                .allowedHeaders("*")
                .allowCredentials(true);
            }
        };
    }
}

package com.example.wantedbackend.global.jwt.config;

import com.example.wantedbackend.global.jwt.JwtInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class JwtConfig implements WebMvcConfigurer {

    private final JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/members/*")
                .excludePathPatterns("/posts/list/**")
                .excludePathPatterns("/health-check")
        ;
    }

}

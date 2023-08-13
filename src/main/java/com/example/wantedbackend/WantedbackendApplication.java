package com.example.wantedbackend;

import com.example.wantedbackend.util.jwt.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class WantedbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WantedbackendApplication.class, args);
    }

}

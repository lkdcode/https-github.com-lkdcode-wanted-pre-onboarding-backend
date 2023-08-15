package com.example.wantedbackend.config;


import com.example.wantedbackend.support.Constants;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = Constants.BASE_PACKAGE)
public class PropertiesConfig {
}

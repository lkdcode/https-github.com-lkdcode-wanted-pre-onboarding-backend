package com.example.wantedbackend.util.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@ConfigurationProperties(prefix = "app.jwt")
@ConfigurationPropertiesBinding
@ConfigurationPropertiesScan
public record JwtProperties(
        // 1. 토큰 Properties에서 jwt 비밀번호를 가져온다.
        String secret,
        Long expiredIn
) {

    public Key getSecretKey() {
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(secret);

        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

}
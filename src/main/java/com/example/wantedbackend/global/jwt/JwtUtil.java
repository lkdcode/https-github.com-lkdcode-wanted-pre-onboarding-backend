package com.example.wantedbackend.global.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class JwtUtil {

    @Value("${jwt.secret-key}")
    private String SECRET_KEY;
    private final long ACCESS_TOKEN_VALID_TIME = 2 * 60 * 60 * 1000L;

    public boolean isExpired(String token) {
        SecretKey key = getSecretKey(SECRET_KEY);

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration()
                .before(new Date());
    }

    public String getUserName(String token) {
        SecretKey key = getSecretKey(SECRET_KEY);

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userAccount", String.class);
    }

    public String createToken(String userAccount) {
        Claims claims = Jwts.claims();
        claims.put("userAccount", userAccount);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALID_TIME))
                .signWith(secretKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private SecretKey secretKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private SecretKey getSecretKey(String secretKey) {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);

        return Keys.hmacShaKeyFor(keyBytes);
    }

}

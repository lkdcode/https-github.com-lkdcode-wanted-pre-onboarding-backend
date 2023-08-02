package com.example.wantedbackend.global.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtProvider {

    // private final MemberRepository memberRepository;
    // private final AuthRepository authRepository;
    private final String ACCOUNT = "ACCOUNT";
    private final String NICKNAME = "NICKNAME";
    private final String LOGIN_METHOD = "LOGIN_METHOD";
    private final String ISSUER = "wanted";
    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer ";
    private final String REFRESH_TOKEN = "REFRESH_TOKEN";
    private final long ACCESS_TOKEN_VALID_TIME = 2 * 60 * 60 * 1000L;
    private final long REFRESH_TOKEN_VALID_TIME = 60 * 60 * 24 * 7 * 1000L;
    @Value("${jwt.secret-key}")
    private final String SECRET_KEY; // Access Token
    @Value("${jwt.refresh-key}")
    private final String REFRESH_KEY; // Refresh Token

}

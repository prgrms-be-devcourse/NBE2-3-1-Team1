package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * JWT 토큰 생성을 담당하는 클래스
 * 사용자 인증 및 권한 부여를 위해 JWT 생성
 */
@Component
public class JwtTokenProvider {
    // 비밀키
    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 토큰 만료 시간
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    /**
     * 사용자 이메일을 기반으로 JWT 토큰 생성.
     *
     * @param email 토큰의 주제(사용자 식별자)
     * @return 생성된 JWT 토큰 (String 형식)
     */
    public String createToken(String email) {
        return Jwts.builder()
                .setSubject(email)                                                     // 토큰의 주제
                .setIssuedAt(new Date())                                               // 토큰 생성 시간
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 만료 시간
                .signWith(SECRET_KEY)                                                  // 서명
                .compact();                                                            // JWT를 문자열 형태로 직렬화
    }
}

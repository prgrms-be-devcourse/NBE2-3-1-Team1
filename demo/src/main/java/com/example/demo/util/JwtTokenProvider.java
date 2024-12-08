package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

/**
 * JWT 토큰 생성을 담당하는 클래스
 * 사용자 인증 및 권한 부여를 위해 JWT 생성
 */
@Component
public class JwtTokenProvider {
    // 비밀키
    private static final String SECRET_KEY = "your-secret-key";

    // 토큰 만료 시간
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    /**
     * 서명(Signature)에 사용할 Key 객체 생성
     * SecretKeySpec을 사용하여 비밀키를 HMAC 알고리즘과 연결된 Key로 변환
     *
     * @return 서명에 사용할 Key 객체
     */    private Key getSigningKey() {
        return new SecretKeySpec(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8), // 비밀키를 바이트 배열로 변환
                SignatureAlgorithm.HS256.getJcaName()        // 알고리즘 지정 (HMAC-SHA256)
        );
    }

    /**
     * 사용자 이메일을 기반으로 JWT 토큰 생성
     *
     * @param email 토큰의 주제(사용자 식별자)
     * @return 생성된 JWT 토큰 (String 형식)
     */
    public String createToken(String email) {
        return Jwts.builder()
                .setSubject(email)                                                     // 토큰의 주제
                .setIssuedAt(new Date())                                               // 토큰 생성 시간
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 만료 시간
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)                   // 서명
                .compact();                                                            // JWT를 문자열 형태로 직렬화
    }
}

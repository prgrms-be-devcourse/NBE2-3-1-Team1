package com.example.demo.dto.response;

/**
 * 관리자 로그인 응답 DTO (Data Transfer Object)
 * 로그인 성공 시 클라이언트에게 반환되는 JWT 토큰을 담는 클래스
 */
public record AdminLoginResponse(
        String token
) {}
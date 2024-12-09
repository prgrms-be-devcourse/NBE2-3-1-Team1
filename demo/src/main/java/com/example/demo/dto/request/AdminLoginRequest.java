package com.example.demo.dto.request;

/**
 * 관리자 로그인 요청 DTO (Data Transfer Object)
 * 클라이언트가 로그인 요청 시 이메일과 비밀번호를 전송하는 데 사용
 */
public record AdminLoginRequest(
        String email,
        String password
) {}
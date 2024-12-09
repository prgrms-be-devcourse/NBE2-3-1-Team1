package com.example.demo.controller;

import com.example.demo.dto.request.AdminLoginRequest;
import com.example.demo.dto.response.AdminLoginResponse;
import com.example.demo.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 관리자 API 컨트롤러
 * 관리자와 관련된 REST API 제공
 */
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Tag(name = "Admin API")
public class AdminController {
    private final AdminService adminService;

    /**
     * 관리자 로그인 API
     * 주어진 이메일과 비밀번호를 사용하여 로그인 처리 후 JWT 토큰 반환
     *
     * @param request 관리자 로그인 요청 (이메일과 비밀번호 포함)
     * @return JWT 토큰을 포함한 응답 객체
     */
    @Operation(summary = "관리자 로그인 API")
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody AdminLoginRequest request) {
        // AdminService를 호출하여 로그인 처리 후 JWT 토큰 생성
        String token = adminService.login(request.email(), request.password());
        // JWT 토큰을 응답으로 반환
        return ResponseEntity.ok(new AdminLoginResponse(token));
    }
}

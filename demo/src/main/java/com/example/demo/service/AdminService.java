package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.util.JwtTokenProvider;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 관리자(Admin) 서비스 클래스
 * 관리자 로그인 로직을 처리하며, JWT 토큰 생성 담당
 */
@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 관리자 로그인 메서드
     * 주어진 이메일과 비밀번호를 검증한 뒤 JWT 토큰을 반환
     *
     * @param email    로그인 요청 관리자의 이메일
     * @param password 로그인 요청 관리자의 비밀번호
     * @return 생성된 JWT 토큰
     * @throws EntityNotFoundException 이메일에 해당하는 관리자가 없는 경우
     * @throws IllegalArgumentException 비밀번호가 일치하지 않는 경우
     */
    public String login(String email, String password) {
        // 1. 이메일을 기반으로 관리자 조회
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("관리자를 찾을 수 없습니다."));

        // 2. 비밀번호 검증
        if (!admin.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 3. JWT 토큰 생성 및 반환
        return jwtTokenProvider.createToken(email);
    }
}

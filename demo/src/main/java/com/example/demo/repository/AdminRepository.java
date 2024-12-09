package com.example.demo.repository;

import com.example.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 관리자(Admin) 엔티티의 데이터베이스 접근을 담당하는 JPA 레포지토리
 * Spring Data JPA를 사용하여 데이터베이스 작업을 간편하게 처리
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {

    /**
     * 이메일을 기반으로 관리자를 조회하는 메서드
     *
     * @param email 검색할 관리자의 이메일
     * @return 이메일에 해당하는 관리자를 Optional로 감싸 반환
     */
    Optional<Admin> findByEmail(String email);
}
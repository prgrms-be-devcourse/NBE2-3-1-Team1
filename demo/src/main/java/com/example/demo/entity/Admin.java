package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 관리자(Admin) 엔티티 클래스
 * 데이터베이스의 'admins' 테이블과 매핑되며, 관리자의 정보를 저장
 */
@Entity
@Getter
@NoArgsConstructor
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role = "ADMIN"; // 기본 역할

    /**
     * 관리자를 생성하는 생성자
     *
     * @param email 관리자 이메일
     * @param password 관리자 비밀번호
     * @param role 관리자 역할
     */
    public Admin(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}

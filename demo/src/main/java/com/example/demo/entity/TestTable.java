package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "TestTable")
public class TestTable {
  @Id
  private Long id;

  @Column(unique = true)
  private String name;

  @Column(nullable = false)
  private Integer age;
}

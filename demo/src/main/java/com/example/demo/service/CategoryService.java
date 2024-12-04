package com.example.demo.service;

import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.dto.request.ItemRequest;
import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(CategoryRequest.Create dto) {
        return categoryRepository.save(Category.toCategory(dto));
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("카테고리를 찾을 수 없습니다."));
    }

    @Transactional
    public Category updateCategory(Long categoryId, CategoryRequest.Create dto) {
        log.info("수정 dto.name ={}", dto.name());
        Category category = getCategoryById(categoryId); //  db 가져옴
        category.updateCategory(dto.name());  // 사용자 요청을 db에서 불러온 데이터를 수정
        log.info("수정 categoryName = {}", category.getName());
        return categoryRepository.save(category); // db 에 저장
    }

    @Transactional
    public void deleteCategory(Long categoryId) {
        log.info("삭제 categoryId = {}", categoryId);
        Category category = getCategoryById(categoryId);
        if (category == null) {
            log.info("삭제 categoryId = {} 는 없습니다.", categoryId);
        } else {
            categoryRepository.deleteById(categoryId);
        }
    }
}



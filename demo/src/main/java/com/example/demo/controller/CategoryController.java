package com.example.demo.controller;


import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.dto.response.CategoryResponse;
import com.example.demo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@Tag(name = "Category API")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "카테고리 추가 API")
    @PostMapping()
    public ResponseEntity<CategoryResponse.Create> createCategory(CategoryRequest.Create dto) {
        return ResponseEntity.ok().body(
                CategoryResponse.Create.from(categoryService.createCategory(dto)));
    }

    // TODO 지영님 카테고리 수정 / {categoryId}


    // TODO 지영님 카테고리 삭제 / {categoryId}

}

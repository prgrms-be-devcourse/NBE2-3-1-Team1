package com.example.demo.controller;


import com.example.demo.dto.request.CategoryRequest;
import com.example.demo.dto.response.CategoryResponse;
import com.example.demo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@Tag(name = "Category API")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "카테고리 추가 API")
    @PostMapping()
    public ResponseEntity<CategoryResponse.Create> createCategory(@RequestBody CategoryRequest.Create dto) {
        return ResponseEntity.ok().body(
                CategoryResponse.Create.from(categoryService.createCategory(dto)));
    }

    @Operation(summary = "카테고리 수정 API")
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse.Create> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody CategoryRequest.Create dto) {
        return ResponseEntity.ok().body(
                CategoryResponse.Create.from(categoryService.updateCategory(categoryId, dto))
        );
    }

    @Operation(summary = "카테고리 삭제 API")
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse.Create> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}

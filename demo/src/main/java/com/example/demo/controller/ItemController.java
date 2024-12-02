package com.example.demo.controller;

import com.example.demo.dto.request.ItemRequest;
import com.example.demo.dto.response.ItemResponse;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
@Tag(name = "Item API")
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    @Operation(summary = "상품 추가 API")
    @PostMapping
    public ResponseEntity<ItemResponse.Create> createItem(ItemRequest.Create dto) {
        return ResponseEntity.ok().body(
                ItemResponse.Create.from(itemService.createItem(dto, categoryService.getCategoryById(dto.categoryId()))));
    }
}

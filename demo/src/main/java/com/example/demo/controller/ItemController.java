package com.example.demo.controller;

import com.example.demo.dto.request.ItemRequest;
import com.example.demo.dto.response.ItemResponse;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
@Tag(name = "Item API")
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    @Operation(summary = "상품 추가 API")
    @PostMapping
    public ResponseEntity<ItemResponse.Create> createItem(@RequestBody ItemRequest.Create dto) {
        return ResponseEntity.ok().body(
                ItemResponse.Create.from(itemService.createItem(dto, categoryService.getCategoryById(dto.categoryId()))));
    }

    @Operation(summary = "상품 개별 조회 API")
    @GetMapping("/{itemId}")
    public ResponseEntity<ItemResponse.Create> getItemById(@PathVariable(name = "itemId") Long itemId) {
        return ResponseEntity.ok().body(
                ItemResponse.Create.from(itemService.getItemById(itemId))
        );
    }

    @Operation(summary = "전체 상품 조회")
    @GetMapping
    public ResponseEntity<List<ItemResponse.Create>> getAllItems() {
        return ResponseEntity.ok().body(
                itemService.getAllItems().stream()
                        .map(ItemResponse.Create::from)
                        .collect(Collectors.toList())
        );
    }

    @Operation(summary = "상품 수정 API")
    @PutMapping("/{itemId}")
    public ResponseEntity<ItemResponse.Create> updateItem(@PathVariable("itemId") Long itemId, @RequestBody ItemRequest.Create dto) {
        return ResponseEntity.ok().body(
                ItemResponse.Create.from(
                        itemService.updateItem(itemId, dto, categoryService.getCategoryById(dto.categoryId()))
                )
        );
    }

    @Operation(summary = "상품 삭제 API")
    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "상품 재고 추가 API")
    @PostMapping("/{itemId}/stock/add")
    public ResponseEntity<ItemResponse.Create> addStock(@PathVariable("itemId") Long itemId,
                                                        @RequestParam("quantity") int quantity) {
        return ResponseEntity.ok()
                .body(ItemResponse.Create.from(itemService.addStock(itemId, quantity)));
    }

    @Operation(summary = "상품 재고 감소 API")
    @PostMapping("/{itemId}/stock/remove")
    public ResponseEntity<ItemResponse.Create> removeStock(
            @PathVariable("itemId") Long itemId,
            @RequestParam("quantity") int quantity) {
        return ResponseEntity.ok()
                .body(ItemResponse.Create.from(itemService.removeStock(itemId, quantity)));
    }
}


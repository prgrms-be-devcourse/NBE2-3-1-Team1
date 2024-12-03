package com.example.demo.service;

import com.example.demo.dto.request.ItemRequest;
import com.example.demo.entity.Category;
import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class ItemService {

    public final ItemRepository itemRepository;

    @Transactional
    public Item createItem(ItemRequest.Create dto, Category category) {
        return itemRepository.save(Item.toItem(dto, category));
    }

    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다."));
    }

    /* TODO 카테고리별, 전체 아이템 별 */
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    /* TODO 상품 수정 */
    @Transactional
    public Item updateItem(Long itemId, ItemRequest.Create dto, Category category) {
        log.info("수정 categoryId = {},dto.name ={}", category.getId(), dto.name());
        Item item = getItemById(itemId);
        log.info("수정 categoryId = {},dto.name ={}", item.getCategory(), item.getId());
        item.updateItem(dto.name(), dto.price(), category);
        log.info("수정 categoryId = {},dto.name ={}", item.getCategory(), item.getId());
        return itemRepository.save(item);
    }

    /* TODO 상품 삭제 */
    @Transactional
    public void deleteItem(Long itemId) {
        log.info("삭제 itemId = {}", itemId);
        itemRepository.deleteById(itemId);
    }

}

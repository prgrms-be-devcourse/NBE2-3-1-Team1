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
        if (itemRepository.existsByNameAndCategory(dto.name(), category)) {
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }
        return itemRepository.save(Item.toItem(dto, category));
    }

    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다."));
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Transactional
    public Item updateItem(Long itemId, ItemRequest.Create dto, Category category) {
        if (itemRepository.existsByNameAndCategoryAndIdNot(dto.name(), category, itemId)) {
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }
        Item item = getItemById(itemId);
        item.updateItem(dto.name(),dto.price(),category);
        return item;
    }

    @Transactional
    public void deleteItem(Long itemId) {
        log.info("삭제 itemId = {}", itemId);
        itemRepository.deleteById(itemId);
    }

}

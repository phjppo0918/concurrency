package me.example.concurrency.application.impl;


import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.ItemQueryService;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemQueryServiceImpl implements ItemQueryService {
    private final ItemRepository itemRepository;

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}

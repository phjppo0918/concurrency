package me.example.concurrency.application.service;


import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.GetAllItemUseCase;
import me.example.concurrency.application.GetOneItemUseCase;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemQueryService implements GetOneItemUseCase, GetAllItemUseCase {
    private final ItemRepository itemRepository;

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(NotFoundItemException::new);
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}

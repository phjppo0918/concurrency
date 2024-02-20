package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemDeleteService {
    private final ItemRepository itemRepository;

    public void deleteById(final Long id) {
        itemRepository.deleteById(id);
    }
}

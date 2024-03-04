package me.example.concurrency.application.impl;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.DeleteItemService;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteItemServiceImpl implements DeleteItemService {
    private final ItemRepository itemRepository;

    @Override
    public void deleteById(final Long id) {
        itemRepository.deleteById(id);
    }
}

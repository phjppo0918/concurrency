package me.example.concurrency.application.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdjustItemQuantityServiceImpl implements AdjustItemQuantityService {
    private final ItemRepository itemRepository;
    @Override
    @Transactional
    public void increase(final AdjustQuantityCommand command) {
        final Item item = itemRepository.findById(command.itemId())
                .orElseThrow();

        item.increase(command.amount());
    }

    @Override
    @Transactional
    public void decrease(final AdjustQuantityCommand command) {
        final Item item = itemRepository.findById(command.itemId())
                .orElseThrow();

        item.decrease(command.amount());
    }
}

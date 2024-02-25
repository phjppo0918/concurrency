package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemIncreaseService {
    private final ItemRepository itemRepository;

    @Transactional
    public synchronized void increase(final AdjustQuantityCommand command) {
        final Item item = itemRepository.findById(command.itemId())
                .orElseThrow(NotFoundItemException::new);

        item.increase(command.amount());
    }
}

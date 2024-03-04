package me.example.concurrency.application.impl;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.CreateItemService;
import me.example.concurrency.application.command.CreateItemCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.domain.Stock;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemServiceImpl implements CreateItemService {
    private final ItemRepository itemRepository;

    @Override
    public long create(final CreateItemCommand command) {
        final Stock stock = new Stock(command.quantity());
        Item savedItem = itemRepository.save(new Item(command.name(), stock));

        return savedItem.getId();
    }
}

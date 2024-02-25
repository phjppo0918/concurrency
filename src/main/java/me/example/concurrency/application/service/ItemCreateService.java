package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.CreateItemCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.domain.Stock;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCreateService {

    private final ItemRepository itemRepository;
    private final OptimizedCallBack optimizedCallBack;

    public long itemCreate(final CreateItemCommand command) {
        final Stock stock = new Stock(command.quantity());
        Item savedItem = optimizedCallBack.run(() ->
                itemRepository.save(new Item(command.name(), stock))
        );

        return savedItem.getId();
    }
}

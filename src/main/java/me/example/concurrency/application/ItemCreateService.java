package me.example.concurrency.application;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCreateService {

    private final ItemRepository itemRepository;

    public void itemCreate() {
        final Item item = itemRepository.save(new Item(1L, "아이템"));
        itemRepository.save(item);
    }
}

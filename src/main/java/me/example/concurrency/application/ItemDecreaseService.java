package me.example.concurrency.application;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemDecreaseService {

    private final ItemRepository itemRepository;

    @Transactional
    public void decrease() {
        final Item item = itemRepository.findById(1L)
            .orElseThrow();
        item.decrease(1L);
    }
}

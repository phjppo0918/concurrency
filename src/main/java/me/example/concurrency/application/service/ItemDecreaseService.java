package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemDecreaseService {

    private final ItemRepository itemRepository;
    private final OptimizedCallBack optimizedCallBack;

    public void decrease(final AdjustQuantityCommand command) {
        optimizedCallBack.run(() -> {
            final Item item = itemRepository.findById(command.itemId())
                    .orElseThrow(NotFoundItemException::new);
            item.decrease(command.amount());
            itemRepository.save(item);
        });
    }
}

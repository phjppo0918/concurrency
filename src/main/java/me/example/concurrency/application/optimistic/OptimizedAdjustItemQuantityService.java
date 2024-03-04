package me.example.concurrency.application.optimistic;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;

@RequiredArgsConstructor
public class OptimizedAdjustItemQuantityService implements AdjustItemQuantityService {
    private final ItemRepository itemRepository;
    private final OptimizedCallBack optimizedCallBack;
    @Override
    public void increase(final AdjustQuantityCommand command) {
        optimizedCallBack.run(() -> {
            final Item item = itemRepository.findById(command.itemId())
                    .orElseThrow();
            item.increase(command.amount());
            itemRepository.save(item);
        });
    }

    @Override
    public void decrease(final AdjustQuantityCommand command) {
        optimizedCallBack.run(() -> {
            final Item item = itemRepository.findById(command.itemId())
                    .orElseThrow();
            item.decrease(command.amount());
            itemRepository.save(item);
        });
    }
}

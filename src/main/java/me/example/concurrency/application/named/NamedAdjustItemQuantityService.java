package me.example.concurrency.application.named;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class NamedAdjustItemQuantityService implements AdjustItemQuantityService {
    private final ItemRepository itemRepository;

    @Override
    public void increase(final AdjustQuantityCommand command) {
        final Item item = itemRepository.findById(command.itemId())
                .orElseThrow();
        item.increase(command.amount());
    }

    @Override
    public void decrease(final AdjustQuantityCommand command) {
        final Item item = itemRepository.findById(command.itemId())
                .orElseThrow();
        item.decrease(command.amount());
    }

}

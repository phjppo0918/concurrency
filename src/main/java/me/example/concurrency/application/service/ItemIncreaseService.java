package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ItemIncreaseService {
    private final ItemRepository itemRepository;
    private final OptimizedCallBack optimizedCallBack;
   // @Transactional
    public void increase(final AdjustQuantityCommand command) {

        optimizedCallBack.run(() -> {
            final Item item = itemRepository.findById(command.itemId())
                    .orElseThrow(NotFoundItemException::new);
            item.increase(command.amount());
            itemRepository.save(item);
        });
    }
}

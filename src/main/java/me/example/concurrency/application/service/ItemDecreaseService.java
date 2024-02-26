package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemDecreaseService {
    private final ItemRepository itemRepository;

    private final DecreaseDao decreaseDao;

    @Transactional
    public void decrease(final AdjustQuantityCommand command) {
        decreaseDao.decrease(command.itemId(), command.amount());
        checkMinus(command);
    }

    private void checkMinus(final AdjustQuantityCommand command) {
        final Item item = itemRepository.findById(command.itemId()).orElseThrow();
        item.decrease(0L);
    }
}

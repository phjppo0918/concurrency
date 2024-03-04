package me.example.concurrency.application.mvcc;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.infrastructure.named.NamedAdjustItemDao;

@Transactional
@RequiredArgsConstructor
public class MvccAdjustItemQuantityService implements AdjustItemQuantityService {
    private final NamedAdjustItemDao namedAdjustItemDao;

    @Override
    @Transactional
    public void increase(final AdjustQuantityCommand command) {
        namedAdjustItemDao.increase(command.itemId(), command.amount());
    }

    @Override
    @Transactional
    public void decrease(final AdjustQuantityCommand command) {
        namedAdjustItemDao.decrease(command.itemId(), command.amount());
        checkMinus(command);
    }

    private void checkMinus(final AdjustQuantityCommand command) {
        final Item item = namedAdjustItemDao.findById(command.itemId()).orElseThrow();
        item.decrease(0L);
    }
}

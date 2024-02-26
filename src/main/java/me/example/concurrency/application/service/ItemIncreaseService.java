package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemIncreaseService {
    private final IncreaseDao increaseDao;
    @Transactional
    public void increase(final AdjustQuantityCommand command) {
        increaseDao.increase(command.itemId(), command.amount());
    }
}

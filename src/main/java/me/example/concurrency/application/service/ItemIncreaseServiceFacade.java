package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.infrastructure.LockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemIncreaseServiceFacade {
    private final ItemIncreaseService increaseService;

    private final LockRepository lockRepository;

    @Transactional
    public void increase(final AdjustQuantityCommand command) {
        final String key = String.valueOf(command.itemId());
        try {
            lockRepository.getLock(key);
            increaseService.increase(command);
        } finally {
            lockRepository.releaseLock(key);
        }
    }
}

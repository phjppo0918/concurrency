package me.example.concurrency.application.named;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.infrastructure.named.LockRepository;

@RequiredArgsConstructor
public class NamedLockProxy implements AdjustItemQuantityService {
    private final AdjustItemQuantityService service;
    private final LockRepository lockRepository;

    @Override
    @Transactional
    public void increase(final AdjustQuantityCommand command) {
        final String key = String.valueOf(command.itemId());
        try {
            lockRepository.getLock(key);
            service.increase(command);
        } finally {
            lockRepository.releaseLock(key);
        }
    }

    @Override
    @Transactional
    public void decrease(final AdjustQuantityCommand command) {
        final String key = String.valueOf(command.itemId());
        try {
            lockRepository.getLock(key);
            service.decrease(command);
        } finally {
            lockRepository.releaseLock(key);
        }
    }
}

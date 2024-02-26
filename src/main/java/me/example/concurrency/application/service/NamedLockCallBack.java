package me.example.concurrency.application.service;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.infrastructure.LockRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Deprecated
@Component
@RequiredArgsConstructor
public class NamedLockCallBack {
    private final LockRepository lockRepository;

    @Transactional
    public void run(final String key, final Runnable runnable) {
        try {
            lockRepository.getLock(key);
            runnable.run();
        } finally {
            lockRepository.releaseLock(key);
        }

    }
}

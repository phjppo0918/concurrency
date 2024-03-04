package me.example.concurrency.application.named;

import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.infrastructure.ItemJpaRepository;
import me.example.concurrency.infrastructure.ItemRepositoryAdapter;
import me.example.concurrency.infrastructure.named.LockRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class NamedTestConfig {
    @Bean
    public AdjustItemQuantityService adjustItemQuantityService(ItemRepository itemRepository, LockRepository lockRepository) {
        return new NamedLockProxy(new NamedAdjustItemQuantityService(itemRepository),lockRepository);
    }

    @Bean
    ItemRepository itemRepository(ItemJpaRepository repository) {
        return new ItemRepositoryAdapter(repository);
    }
}

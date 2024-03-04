package me.example.concurrency.application.pessimistic;

import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.infrastructure.ItemRepositoryAdapter;
import me.example.concurrency.infrastructure.pessimistic.ItemPessimisticJpaRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class PessimisticTestConfig {
    @Bean
    public AdjustItemQuantityService adjustItemQuantityService(ItemRepository itemRepository) {
        return new PessimisticAdjustItemQuantityService(itemRepository);
    }

    @Bean
    public ItemRepository itemRepository(ItemPessimisticJpaRepository repository) {
        return new ItemRepositoryAdapter(repository);
    }
}

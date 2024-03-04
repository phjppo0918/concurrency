package me.example.concurrency.application.optimistic;

import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.infrastructure.ItemRepositoryAdapter;
import me.example.concurrency.infrastructure.optimistic.ItemOptimisticJpaRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class OptimisticTestConfig {
    @Bean
    public AdjustItemQuantityService adjustItemQuantityService(ItemRepository itemRepository, OptimizedCallBack callBack) {
        return new OptimizedAdjustItemQuantityService(itemRepository, callBack);
    }

    @Bean
    public ItemRepository itemRepository(ItemOptimisticJpaRepository repository) {
        return new ItemRepositoryAdapter(repository);
    }
}

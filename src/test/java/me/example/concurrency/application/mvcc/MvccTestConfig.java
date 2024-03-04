package me.example.concurrency.application.mvcc;

import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.infrastructure.named.NamedAdjustItemDao;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class MvccTestConfig {
    @Bean
    public AdjustItemQuantityService adjustItemQuantityService(NamedAdjustItemDao dao) {
        return new MvccAdjustItemQuantityService(dao);
    }
}

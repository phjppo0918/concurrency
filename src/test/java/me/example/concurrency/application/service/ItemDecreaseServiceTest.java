package me.example.concurrency.application.service;

import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.domain.Stock;
import me.example.concurrency.util.ConcurrentExecutor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemDecreaseServiceTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemDecreaseService itemDecreaseService;

    @AfterEach
    void cleanUp() {
        itemRepository.deleteAll();
    }

    @Test
    @DisplayName("재고를 감소한다.")
    void decrease() {
        final long id = itemRepository.save(new Item("사과", new Stock(1000))).getId();

        itemDecreaseService.decrease(new AdjustQuantityCommand(id, 50));

        final Item result = itemRepository.findById(id).get();

        Assertions.assertThat(result.getStock()).isEqualTo(new Stock(950));
    }

    @Test
    @DisplayName("재고를 동시에 감소한다.")
    void decreaseConcurrency() {
        final long id = itemRepository.save(new Item("사과", new Stock(10000))).getId();

        ConcurrentExecutor.execute(
                () ->  itemDecreaseService.decrease(new AdjustQuantityCommand(id, 10)),
                100
        );

        final Item result = itemRepository.findById(id).get();

        Assertions.assertThat(result.getStock()).isEqualTo(new Stock(9000));
    }
}
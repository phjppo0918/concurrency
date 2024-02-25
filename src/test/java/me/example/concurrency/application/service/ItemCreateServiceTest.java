package me.example.concurrency.application.service;

import me.example.concurrency.application.command.CreateItemCommand;
import me.example.concurrency.domain.ItemRepository;
import me.example.concurrency.util.ConcurrentExecutor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemCreateServiceTest {
    @Autowired
    ItemCreateService itemCreateService;
    @Autowired
    ItemRepository itemRepository;

    @AfterEach
    void cleanUp() {
        itemRepository.deleteAll();
    }

    @Test
    @DisplayName("재고를 생성한다.")
    void create() {
        final long saved = itemCreateService.itemCreate(new CreateItemCommand("당근", 1000));

        Assertions.assertThat(itemRepository.findAll()).hasSize(1);
        Assertions.assertThat(itemRepository.findById(saved)).isNotNull();
    }

    @Test
    @DisplayName("재고를 동시에 생성한다")
    void createConcurrency() {
        ConcurrentExecutor.execute(() ->
            itemCreateService.itemCreate(new CreateItemCommand("당근", 1000))
        , 10000);

        Assertions.assertThat(itemRepository.findAll()).hasSize(10000);
    }


}
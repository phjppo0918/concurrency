package me.example.concurrency.application;

import me.example.concurrency.domain.Item;

public interface GetOneItemUseCase {
    Item getById(Long id);
}

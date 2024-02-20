package me.example.concurrency.application;

import me.example.concurrency.domain.Item;

import java.util.List;

public interface GetAllItemUseCase {
    List<Item> getAll();
}

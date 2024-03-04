package me.example.concurrency.application;

import me.example.concurrency.domain.Item;

import java.util.List;

public interface ItemQueryService {
    Item getById(Long id);

    List<Item> getAll();
}

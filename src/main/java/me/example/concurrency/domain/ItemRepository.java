package me.example.concurrency.domain;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {

    Optional<Item> findById(final Long id);

    Item save(Item item);

    List<Item> findAll();

    void deleteById(Long id);
}

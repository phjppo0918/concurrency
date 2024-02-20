package me.example.concurrency.infrastructure;

import java.util.List;
import java.util.Optional;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryAdapter implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    public ItemRepositoryAdapter(ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Override
    public Optional<Item> findById(final Long id) {
        return Optional.empty();
    }

    @Override
    public Item save(final Item item) {
        return null;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }
}

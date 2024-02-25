package me.example.concurrency.infrastructure;

import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemRepositoryAdapter implements ItemRepository {

    private final ItemJpaRepository itemJpaRepository;

    public ItemRepositoryAdapter(ItemJpaRepository itemJpaRepository) {
        this.itemJpaRepository = itemJpaRepository;
    }

    @Override
    public Optional<Item> findById(final Long id) {
        return itemJpaRepository.findById(id);
    }

    @Override
    public Item save(final Item item) {
        return itemJpaRepository.save(item);
    }

    @Override
    public List<Item> findAll() {
        return itemJpaRepository.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        itemJpaRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        itemJpaRepository.deleteAll();
    }
}

package me.example.concurrency.infrastructure;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.domain.Item;
import me.example.concurrency.domain.ItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class ItemRepositoryAdapter implements ItemRepository {

    private final JpaRepository<Item, Long> jpaRepository;
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

    @Override
    public void deleteById(final Long id) {

    }

    @Override
    public void deleteAll() {

    }
}

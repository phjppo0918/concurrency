package me.example.concurrency.infrastructure.optimistic;

import jakarta.persistence.LockModeType;
import me.example.concurrency.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface ItemOptimisticJpaRepository extends JpaRepository<Item, Long> {
    @Lock(LockModeType.OPTIMISTIC)
    Optional<Item> findById(Long id);
}

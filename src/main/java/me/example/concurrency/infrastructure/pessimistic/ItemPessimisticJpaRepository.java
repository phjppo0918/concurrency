package me.example.concurrency.infrastructure.pessimistic;

import jakarta.persistence.LockModeType;
import me.example.concurrency.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemPessimisticJpaRepository extends JpaRepository<Item, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select i from Item i where i.id=:id")
    Optional<Item> findById(@Param("id") Long id);
}
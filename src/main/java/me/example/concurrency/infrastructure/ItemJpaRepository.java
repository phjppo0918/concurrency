package me.example.concurrency.infrastructure;

import me.example.concurrency.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<Item, Long> {

}

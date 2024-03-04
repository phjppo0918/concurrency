package me.example.concurrency.infrastructure;

import me.example.concurrency.domain.Item;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

@Primary
public interface ItemJpaRepository extends JpaRepository<Item, Long> {

}

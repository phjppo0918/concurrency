package me.example.concurrency.infrastructure.named;

import me.example.concurrency.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NamedAdjustItemDao extends JpaRepository<Item, Long> {

    @Modifying
    @Query("UPDATE Item i SET i.stock.value = i.stock.value + :amount where i.id = :id")
    void increase(@Param("id") Long id, @Param("amount") Long amount);

    @Modifying
    @Query("UPDATE Item i SET i.stock.value = i.stock.value - :amount where i.id = :id")
    void decrease(@Param("id") Long id, @Param("amount") Long amount);
}

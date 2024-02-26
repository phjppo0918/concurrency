package me.example.concurrency.application.service;

import me.example.concurrency.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncreaseDao extends JpaRepository<Item, Long> {

    @Modifying
    @Query("UPDATE Item i SET i.stock.value = i.stock.value + :amount where i.id = :id")
    void increase(@Param("id") Long id, @Param("amount") Long amount);
}

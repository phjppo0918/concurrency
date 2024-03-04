package me.example.concurrency.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Stock stock;

    @Version
    private Long version;

    public Item(
            final String name,
            final Stock stock
    ) {
        this.name = name;
        this.stock = stock;
    }

    public void decrease(final Long decreaseAmount) {
        this.stock = this.stock.decrease(decreaseAmount);
    }

    public void increase(final Long increaseAmount) {
        this.stock = this.stock.increase(increaseAmount);
    }
}
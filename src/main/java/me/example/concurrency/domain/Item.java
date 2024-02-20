package me.example.concurrency.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private Long quantity;

    public Item(
        final Long id,
        final String name,
        final Long quantity
    ) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public void decrease(final Long quantity) {
        this.quantity = this.quantity - quantity;
    }
}

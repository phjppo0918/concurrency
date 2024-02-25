package me.example.concurrency.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock {
    @Column(name = "quantity", nullable = false)
    private long value;

    public Stock(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value < 0) {
            throw new OutOfStockException();
        }
    }

    public Stock increase(long value) {
        return new Stock(this.value + value);
    }

    public Stock decrease(long value) {
        return new Stock(this.value - value);
    }
}

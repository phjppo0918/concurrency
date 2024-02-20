package me.example.concurrency.presentation.request;

import jakarta.validation.constraints.NotNull;

public record AdjustItemQuantityRequest(
        @NotNull long amount
) {
}

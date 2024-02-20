package me.example.concurrency.application.command;

public record AdjustQuantityCommand(
        long itemId,
        long amount
) {
}

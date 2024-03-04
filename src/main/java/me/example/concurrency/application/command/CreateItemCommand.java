package me.example.concurrency.application.command;

public record CreateItemCommand(
        String name,
        long quantity
) {
}


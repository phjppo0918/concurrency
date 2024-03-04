package me.example.concurrency.application;

import me.example.concurrency.application.command.AdjustQuantityCommand;

public interface AdjustItemQuantityService {
    void increase(AdjustQuantityCommand command);

    void decrease(AdjustQuantityCommand command);
}

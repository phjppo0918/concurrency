package me.example.concurrency.application;

import me.example.concurrency.application.command.CreateItemCommand;

public interface CreateItemService {

    long create(CreateItemCommand command);
}

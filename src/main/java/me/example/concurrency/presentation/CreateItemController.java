package me.example.concurrency.presentation;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.CreateItemService;
import me.example.concurrency.application.command.CreateItemCommand;
import me.example.concurrency.presentation.request.CreateItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class CreateItemController {
    private final CreateItemService createItemService;

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody @Valid CreateItemRequest request) {
        final long saved = createItemService.create(new CreateItemCommand(request.name(), request.quantity()));
        return ResponseEntity.created(URI.create("/items/" + saved))
                .build();
    }
}

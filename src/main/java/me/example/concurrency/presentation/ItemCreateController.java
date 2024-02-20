package me.example.concurrency.presentation;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.command.CreateItemCommand;
import me.example.concurrency.application.service.ItemCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemCreateController {
    private final ItemCreateService itemCreateService;

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody @Valid CreateItemCommand request) {
        final long saved = itemCreateService.itemCreate(request);
        return ResponseEntity.created(URI.create("/items/" + saved))
                .build();
    }
}

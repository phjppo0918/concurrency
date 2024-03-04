package me.example.concurrency.presentation;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.ItemQueryService;
import me.example.concurrency.domain.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemQueryController {
    private final ItemQueryService itemQueryService;

    @GetMapping
    public List<Item> getAll() {
        return itemQueryService.getAll();
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable Long id) {
        return itemQueryService.getById(id);
    }

}
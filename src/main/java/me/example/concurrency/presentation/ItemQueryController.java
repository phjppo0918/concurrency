package me.example.concurrency.presentation;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.GetAllItemUseCase;
import me.example.concurrency.application.GetOneItemUseCase;
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
    private final GetAllItemUseCase getAllItemUseCase;
    private final GetOneItemUseCase getOneItemUseCase;

    @GetMapping
    public List<Item> getAll() {
        return getAllItemUseCase.getAll();
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable Long id) {
        return getOneItemUseCase.getById(id);
    }

}

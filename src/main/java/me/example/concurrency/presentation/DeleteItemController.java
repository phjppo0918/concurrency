package me.example.concurrency.presentation;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.service.ItemDeleteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class DeleteItemController {
    private final ItemDeleteService itemDeleteService;

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        itemDeleteService.deleteById(id);
    }
}

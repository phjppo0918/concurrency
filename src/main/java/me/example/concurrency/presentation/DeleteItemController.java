package me.example.concurrency.presentation;

import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.DeleteItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class DeleteItemController {
    private final DeleteItemService deleteItemService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        deleteItemService.deleteById(id);
    }
}

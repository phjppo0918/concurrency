package me.example.concurrency.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.service.ItemDecreaseService;
import me.example.concurrency.application.service.ItemIncreaseService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.presentation.request.AdjustItemQuantityRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class AdjustItemQuantityController {

    private final ItemIncreaseService itemIncreaseService;
    private final ItemDecreaseService itemDecreaseService;

    @PostMapping("/increase/{id}")
    public void increaseItemQuantity(@PathVariable Long id, @RequestBody @Valid AdjustItemQuantityRequest request) {
        itemIncreaseService.increase(new AdjustQuantityCommand(id, request.amount()));
    }
    @PostMapping("/decrease/{id}")
    public void decreaseItemQuantity(@PathVariable Long id, @RequestBody @Valid AdjustItemQuantityRequest request) {
        itemDecreaseService.decrease(new AdjustQuantityCommand(id, request.amount()));
    }
}

package me.example.concurrency.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.example.concurrency.application.AdjustItemQuantityService;
import me.example.concurrency.application.command.AdjustQuantityCommand;
import me.example.concurrency.presentation.request.AdjustItemQuantityRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class AdjustItemQuantityController {

    private final AdjustItemQuantityService adjustItemQuantityService;

    @PostMapping("/increase/{id}")
    public void increaseItemQuantity(@PathVariable Long id, @RequestBody @Valid AdjustItemQuantityRequest request) {
        adjustItemQuantityService.increase(new AdjustQuantityCommand(id, request.amount()));
    }
    @PostMapping("/decrease/{id}")
    public void decreaseItemQuantity(@PathVariable Long id, @RequestBody @Valid AdjustItemQuantityRequest request) {
        adjustItemQuantityService.decrease(new AdjustQuantityCommand(id, request.amount()));
    }
}
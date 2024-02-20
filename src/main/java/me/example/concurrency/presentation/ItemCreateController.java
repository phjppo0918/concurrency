package me.example.concurrency.presentation;


import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemCreateController {

    @PostMapping
    public ResponseEntity<Void> createItem() {
        final Long saved = 1L;
        return ResponseEntity.created(URI.create("/items/" + saved))
            .build();
    }
}

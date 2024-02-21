package me.example.concurrency.util;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentExecutor {
    private final ExecutorService service = Executors.newFixedThreadPool(64);

    public void execute(Runnable... tasks) {
        CountDownLatch latch = new CountDownLatch(tasks.length);
        Arrays.stream(tasks).forEach(t -> service.submit(() -> {
            t.run();
            latch.countDown();
        }));
    }
}

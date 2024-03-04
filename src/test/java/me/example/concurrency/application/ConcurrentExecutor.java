package me.example.concurrency.application;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentExecutor {
    private final static ExecutorService service = Executors.newFixedThreadPool(64);

    public static void execute(final Runnable task, final int repeatCount) {
        CountDownLatch latch = new CountDownLatch(repeatCount);
        for (int i = 0; i < repeatCount; i++) {
            service.submit(() -> {
                task.run();
                latch.countDown();
            });
        }
        try {
            latch.await();
        }catch (InterruptedException e) {

        }
    }
}
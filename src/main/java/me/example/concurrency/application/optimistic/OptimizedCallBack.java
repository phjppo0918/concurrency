package me.example.concurrency.application.optimistic;


import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class OptimizedCallBack {
    public <T> T run(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                try {
                    Thread.sleep(20);
                }catch (Exception e2) {

                }
            }
        }
    }

    public void run(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(20);
                }catch (Exception e2) {

                }
            }
        }
    }
}
package com.asn.lib.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                cachedThreadPool.execute(new ThreadExample());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cachedThreadPool.shutdown();
        }
    }
}

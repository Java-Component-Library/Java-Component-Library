package com.asn.lib.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownThreadExample implements Runnable {
    private CountDownLatch countDownLatch;

    public CountDownThreadExample(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            String currentThread = Thread.currentThread().getName();
            System.out.println("current Thread:" + currentThread);
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.countDownLatch.countDown();
        }
    }
}

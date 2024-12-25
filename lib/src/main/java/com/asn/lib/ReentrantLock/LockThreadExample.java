package com.asn.lib.ReentrantLock;

import java.util.List;
import java.util.concurrent.locks.Lock;

public class LockThreadExample implements Runnable {
    private Lock lock;
    private List<String> list;

    public LockThreadExample(Lock lock, List<String> list) {
        this.lock = lock;
        this.list = list;
    }

    @Override
    public void run() {
        try {
            this.lock.lock();
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000L);
                this.list.add("value-" + i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.lock.unlock();
        }
    }
}
package com.asn.lib.executorService;

public class ThreadExample implements Runnable{
    @Override
    public void run() {
        String threadName= Thread.currentThread().getName();
        System.out.println("run " + threadName + " thread");
    }
}

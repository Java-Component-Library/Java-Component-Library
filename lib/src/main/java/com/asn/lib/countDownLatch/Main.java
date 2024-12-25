package com.asn.lib.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        try {
            CountDownLatch cdt = new CountDownLatch(5);

            for (int i = 0; i < 5; i++) {
                es.execute(new CountDownThreadExample(cdt));
            }
            cdt.await();
            System.out.println("thread running finish");
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            es.shutdown();
        }
    }
}

package com.asn.lib.AtomicReference;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class AtomicReferenceSolutionDemo1 {

    static AtomicReference<DebitCard> ref = new AtomicReference(new DebitCard("zhangSan", 10));

    public static void main(String[] args) {



        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {

                while (true){
                    DebitCard debitCard = ref.get();
                    DebitCard newDc = new DebitCard(debitCard.getName(), debitCard.getAccount() + 10);
                    if(ref.compareAndSet(debitCard, newDc)){
                        System.out.println(Thread.currentThread().getName() + " 当前值为： " + newDc.toString() + " " + System.currentTimeMillis());
                    }
                    long sleepValue = (long) (Math.random() * 10000);
                    try {
                        Thread.sleep(sleepValue);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "T-" + i).start();
        });
    }
}

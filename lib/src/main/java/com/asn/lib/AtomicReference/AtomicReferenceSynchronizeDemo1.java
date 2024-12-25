package com.asn.lib.AtomicReference;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AtomicReferenceSynchronizeDemo1 {
    // 定义为 volatile 修饰的变量
    volatile static DebitCard debitCard = new DebitCard("zhangSan", 10);

    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                while (true) {
                    /// 加 锁 操作
                    synchronized (AtomicReferenceDemo1.class) {
                        // 读取全局的 debitCard 对象
                        final DebitCard debitCard1 = debitCard;
                        // 基于全局的 debitCard 加10构建一个新的对象
                        DebitCard newDc = new DebitCard(debitCard1.getName(), debitCard1.getAccount() + 10);
                        // 把新建的都行赋值给 全局的变量
                        debitCard = newDc;
                        System.out.println(newDc);
                        try {
                            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "T-" + i).start();
        });
    }
}

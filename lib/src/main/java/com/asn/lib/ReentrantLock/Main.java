package com.asn.lib.ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) throws Exception {
        Lock lock = new ReentrantLock();
        List<String> list = new ArrayList<String>();
        LockThreadExample a = new LockThreadExample(lock, list);

        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        Thread thread3 = new Thread(a);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(list.size());
    }
}

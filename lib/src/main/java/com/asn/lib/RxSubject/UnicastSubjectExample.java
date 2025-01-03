package com.asn.lib.RxSubject;

import io.reactivex.rxjava3.subjects.*;

public class UnicastSubjectExample {
    public static void main(String[] args) {
        // 創建 UnicastSubject
        UnicastSubject<String> unicastSubject = UnicastSubject.create();

        // 訂閱者1
        unicastSubject.subscribe(event -> System.out.println("Subscriber 1: " + event));

        // 發送事件
        unicastSubject.onNext("Event 1");

        // 創建另一個訂閱者 (會拋出錯誤)
        try {
            unicastSubject.subscribe(event -> System.out.println("Subscriber 2: " + event));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 發送更多事件
        unicastSubject.onNext("Event 2");
        unicastSubject.onComplete();
    }
}

/**
 * Subscriber 1: Event 1
 * Error: Only one observer is allowed
 * Subscriber 1: Event 2
 */

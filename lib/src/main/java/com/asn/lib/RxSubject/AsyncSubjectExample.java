package com.asn.lib.RxSubject;

import io.reactivex.rxjava3.subjects.*;

public class AsyncSubjectExample {
    public static void main(String[] args) {
        // 創建 AsyncSubject
        AsyncSubject<String> asyncSubject = AsyncSubject.create();

        // 訂閱者1
        asyncSubject.subscribe(event -> System.out.println("Subscriber 1: " + event));

        // 發送事件
        asyncSubject.onNext("Event 1");
        asyncSubject.onNext("Event 2");

        // 完成事件發送
        asyncSubject.onComplete();

        // 訂閱者2（會收到最後一個事件 "Event 2"）
        asyncSubject.subscribe(event -> System.out.println("Subscriber 2: " + event));
    }
}

/**
 * Subscriber 1: Event 2
 * Subscriber 2: Event 2
 */

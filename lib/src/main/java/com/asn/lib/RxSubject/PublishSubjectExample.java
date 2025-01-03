package com.asn.lib.RxSubject;

import io.reactivex.rxjava3.subjects.*;

public class PublishSubjectExample {
    public static void main(String args[]) {
        // 創建 PublishSubject
        PublishSubject<String> publishSubject = PublishSubject.create();

        // 訂閱者1
        publishSubject.subscribe(event -> System.out.println("Subscriber 1: " + event));

        // 發送事件
        publishSubject.onNext("Event 1");
        publishSubject.onNext("Event 2");

        // 訂閱者2
        publishSubject.subscribe(event -> System.out.println("Subscriber 2: " + event));

        // 發送更多事件
        publishSubject.onNext("Event 3");
        publishSubject.onComplete();
    }
}


/**
 * Subscriber 1: Event 1
 * Subscriber 1: Event 2
 * Subscriber 1: Event 3
 * Subscriber 2: Event 3
 */

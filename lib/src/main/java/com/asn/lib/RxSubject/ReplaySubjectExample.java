package com.asn.lib.RxSubject;

import io.reactivex.rxjava3.subjects.*;

public class ReplaySubjectExample {
    public static void main(String[] args) {
        // 創建 ReplaySubject
        ReplaySubject<String> replaySubject = ReplaySubject.create();

        // 訂閱者1
        replaySubject.subscribe(event -> System.out.println("Subscriber 1: " + event));

        // 發送事件
        replaySubject.onNext("Event 1");
        replaySubject.onNext("Event 2");

        // 訂閱者2（會收到所有事件 "Event 1" 和 "Event 2"）
        replaySubject.subscribe(event -> System.out.println("Subscriber 2: " + event));

        // 發送更多事件
        replaySubject.onNext("Event 3");
        replaySubject.onComplete();
    }
}

/**
 * Subscriber 1: Event 1
 * Subscriber 1: Event 2
 * Subscriber 2: Event 1
 * Subscriber 2: Event 2
 * Subscriber 1: Event 3
 * Subscriber 2: Event 3
 */

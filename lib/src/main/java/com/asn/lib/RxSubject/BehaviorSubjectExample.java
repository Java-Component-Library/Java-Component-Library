package com.asn.lib.RxSubject;

import io.reactivex.rxjava3.subjects.*;

public class BehaviorSubjectExample {
    public static void main(String[] args) {
        // 創建 BehaviorSubject 並設置初始值
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.createDefault("Initial Value");

        // 訂閱者1
        behaviorSubject.subscribe(event -> System.out.println("Subscriber 1: " + event));

        // 發送事件
        behaviorSubject.onNext("Event 1");
        behaviorSubject.onNext("Event 2");
        // 訂閱者2（此訂閱者會立即收到最後的事件 "Event 1"）
        behaviorSubject.subscribe(event -> System.out.println("Subscriber 2: " + event));

        // 發送更多事件
        behaviorSubject.onNext("Event 3");
        behaviorSubject.onComplete();
    }
}

/**
 * Subscriber 1: Initial Value
 * Subscriber 1: Event 1
 * Subscriber 1: Event 2
 * Subscriber 2: Event 2
 * Subscriber 1: Event 3
 * Subscriber 2: Event 3
 */

package com.asn.lib.WeakReference;

import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        //强引用
        RoleDTO role = new RoleDTO(1, "CEO");

        //弱引用
        WeakReference<RoleDTO> weakReference = new WeakReference<>(new RoleDTO(1, "CTO"));
        //主动让出发GC
        System.gc();
        try {
            //给GC留点时间，保证GC执行完成
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (role == null) {
            System.out.println(new String("Strong RoleDTO Object recycle".getBytes(), StandardCharsets.UTF_8));
        }

        //weakReference.get()获取弱引用指向的对象，如果对象是null，表示被回收
        if (weakReference.get() == null) {
            System.out.println(new String("Weak RoleDTO Object recycle".getBytes(), StandardCharsets.UTF_8));
        }

    }
}
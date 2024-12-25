﻿# Java-Component-Library

## CountDownLatch

1. 當在執行多執行程式時, 如果有一個執行緒需要等待其他執行緒都執行再繼續使用, 就可以使用CountDownLatch  
2. CountDownLatch 的物件時會在建構子裡會指定需要等待多少數量的執行緒，當在執行一個執行緒時這個 count 值就會被減掉 1，等到減到 0 時就代表所有的執行緒都被執行完成了，等待的執行緒就繼續的往下執行。  

CountDownLatch.countDown() 減掉數量  
CountDownLatch.await() 若數量至0時, 從這開始繼續執行  
https://ithelp.ithome.com.tw/articles/10208081?sc=rss.iron 

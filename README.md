# Java-Component-Library

## CountDownLatch

1. 當在執行多執行程式時, 如果有一個執行緒需要等待其他執行緒都執行再繼續使用, 就可以使用CountDownLatch  
2. CountDownLatch 的物件時會在建構子裡會指定需要等待多少數量的執行緒，當在執行一個執行緒時這個 count 值就會被減掉 1，等到減到 0 時就代表所有的執行緒都被執行完成了，等待的執行緒就繼續的往下執行。  

- CountDownLatch.countDown() 減掉數量  
- CountDownLatch.await() 若數量至0時, 從這開始繼續執行
  
https://ithelp.ithome.com.tw/articles/10208081?sc=rss.iron 


## ExecutorService

1. 啟動執行緒方式直接New Thread(), 再去呼叫start方法, 使用這種方法較沒有彈性而且管理比較不方便, Java提供內建Executors & ExecutorService,可以方便開發者管理執行緒。它可以建立執行緒的 Pool 讓我們可以重覆的使用執行緒有效的控制 CPU 資源，另外也可以使用 Sheduler 管理執行緒的排程。因此學會使用 Executors 和 ExecutorService 可以幫助我們方便快速開發多執行緒的程式。  

Executors 提供了 newCacheThreadPool、newFixThreadPool、newSingleThreadExecutor、newScheduledThreadPool、newSingleThreadScheduledExecutor…等等的方法來建立執行緒 Pool。每個方法的說明如下: 
- newCacheThreadPool：執行緒 Pool 發現有執行緒執行完之後，會將資源回收重新的再使用。如果沒有回收的資源，那就會再去建立執行緒。
- newFixThreadPool：執行緒 Pool 只會有固定數量的執行緒再執行，如果啟動的數量超過 pool 的數量那執行緒就會被放入 Queue 等待被執行。
- newSingleThreadExecutor：執行緒 pool 只會有一個執行緒可以執行
- newScheduledThreadPool：執行緒 pool 會按照排程去執行執行緒
- newSingleThreadScheduledExecutor：執行緒 pool 只會有一個執行緒可以按照 scheduler 的排程去執行

https://ithelp.ithome.com.tw/m/articles/10207124 

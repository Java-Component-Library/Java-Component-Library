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


## AtomicReference(AtomicInteger, AtomicBoolean, AtomicLong)

1. 透過對 AtomicInteger、AtomicBoolean 和 AtomicLong 分析我們發現，這三個原子類只能對單一變數進行原子操作，那麼我們如果要對多個變數進行原子操作，這三個類別就無法實現了。那如果要進行多個變數進行原子操作呢？操作方式就是，先把 多個變數封裝成一個類，然後再透過 AtomicReference 進行操作。
2. 眾所周知，物件的引用其實是一個4位元組的數字，代表在JVM堆記憶體中的引用位址，對一個4位元組數字的讀取操作和寫入操作本身就是原子性的，通常情況下，我們物件參考的操作一般都是取得該參考或重新賦值（寫入操作），我們也沒有辦法對物件所引用的4位元組數字進行加減乘除運算，那麼為什麼JDK要提供AtomicReference類別來支援參考型的原子性操作呢？
3. AtomicReference的應用場景
這裡透過設計一個個人銀行帳號資金變化的場景，逐漸引入AtomicReference的使用，該實例有些特殊，需要滿足以下幾點要求。

- 個人帳號被設計為不可變對象，一旦建立就無法進行修改。
- 個人帳號類別只包含兩個欄位：帳號名稱、現金數字。
- 為了方便驗證，我們約定個人帳號的現金只能增加而不能減少。
- 根據前兩個要求，我們簡單設計一個代表個人銀行帳號的Java類DebitCard，該類別將被設計為不可變。  


- AtomicReference的基本用法
  - 建立 AtomicReference
  - AtomicReference是一個泛型類，它的構造與其他原子類型的構造一樣，也提供了無參和一個有參的構造函數。
  - AtomicReference()：當使用無參構造函數來建立AtomicReference物件的時候，需要再次呼叫set()方法為AtomicReference內部的value指定初始值。
  - AtomicReference(V initialValue)：建立AtomicReference物件時順便指定初始值。
- 常用方法
  - compareAndSet(V expect, V update)：原子性地更新AtomicReference內部的value值，其中expect代表目前AtomicReference的value值，update則是需要設定的新參考值。此方法會傳回一個boolean的結果，當expect和AtomicReference的目前值不相等時，修改會失敗，傳回值為false，若修改成功則會回傳true。
  - getAndSet(V newValue)：原子性地更新AtomicReference內部的value值，並且傳回AtomicReference的舊值。
  - getAndUpdate(UnaryOperator<V> updateFunction)：原子性地更新value值，並且傳回AtomicReference的舊值，該方法需要傳入一個Function介面。
  - updateAndGet(UnaryOperator<V> updateFunction)：原子性地更新value值，並且傳回AtomicReference更新後的新值，該方法需要傳入一個Function介面。
  - getAndAccumulate(V x, BinaryOperator<V> accumulatorFunction)：原子性地更新value值，並且傳回AtomicReference更新前的舊值。此方法需要傳入兩個參數，第一個是更新後的新值，第二個是BinaryOperator介面。
  - getAndAccumulate(V x, BinaryOperator<V> accumulatorFunction)：原子性地更新value值，並且傳回AtomicReference更新前的舊值。此方法需要傳入兩個參數，第一個是更新後的新值，第二個是BinaryOperator介面。
  - accumulateAndGet(V x, BinaryOperator<V> accumulatorFunction)：原子性地更新value值，並且傳回AtomicReference更新後的值。此方法需要傳入兩個參數，第一個是更新的新值，第二個是BinaryOperator介面。
  - get()：取得AtomicReference的目前物件參考值。
  - set(V newValue)：設定AtomicReference最新的物件參考值，該新值的更新對其他執行緒立即可見。
  - lazySet(V newValue)：設定AtomicReference的物件參考值。 lazySet方法的原理已經在AtomicInteger中介紹過了，這裡不再贅述。
 
## 補充

1. volatile  讓執行緒中有可見性, 變量每次更改都可以立即被其他線程看到
2. sychronize 速度非常慢, 因為其他線程被卡死了
 
https://blog.csdn.net/small_love/article/details/111058977  


## WeakReference 

java 4種引用類型：
1. 強：A a=new A(); 此時引用a強引用物件A；不會被GC
2. 軟：SoftReference.java，在記憶體不夠時引用物件會被GC；
3. 弱：WeakReference.java，每次GC都會被回收；
4. 虛：PhantomReference.java，每次GC都會被回收；

弱引用指向的對象，每次GC時，物件都會被當作垃圾回收。
![image](https://github.com/user-attachments/assets/06f41119-7d23-4f79-b369-d1371c0408b5)
- RoleDTO role = new RoleDTO();此role變數屬於強引用，GC發生後，它指向的物件不被回收；透過後邊列印，已經證明；
- WeakReference< RoleDTO> weakReference= new WeakReference<>(new RoleDTO());此weakReference是弱引用，GC發生後，它指向的物件被回收，透過列印輸出已經證明。

https://blog.csdn.net/csdn_20150804/article/details/103748869  


## ReentrantLock

1. 介紹 java.util.concurrent.locks package 下面 ReentrantLock 的類別，它是屬於 Lock 的一種實作，其實 ReentrantLock 相似於前面幾天所提到的 Synchronized。它們之間主要的差別在於 ReentrantLock 有 Lock 和 Unlock 開發程式的人要自已的控制鎖， Synchronized 會自動的幫我們控制鎖。
2. ReentrantLock 類別主要提供了 lock()、unlock()、newCondition()、tryLock()…等等的方法，今天主要是介紹使用 lock 和 unlock 方法。
3. lock 方法主要是要把保護的變數鎖圯來，然後 unlock 方法主要是把鎖打開來，讓其它的執行緒去取得共享變數的存取。

https://ithelp.ithome.com.tw/m/articles/10205898  


## RxSubject
![image](https://github.com/user-attachments/assets/f8b66e51-5b47-4260-b33a-b984c3097100)








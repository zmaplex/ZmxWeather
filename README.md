# ZmxWeather

- 注意：需要手动赋予存储权限！！！

[![Screenshot_1557198425.png](https://i.loli.net/2019/05/07/5cd0f67da5e00.png)](https://i.loli.net/2019/05/07/5cd0f67da5e00.png)
[![Screenshot_1557198292.png](https://i.loli.net/2019/05/07/5cd0f67daf8a8.png)](https://i.loli.net/2019/05/07/5cd0f67daf8a8.png)

# RxJava2 学习资料
学习使用 Mvp+ RxJava + Retrofit2 设计天气APP
RxJava 有以下三个基本的元素：

1. 被观察者（Observable）
2. 观察者（Observer）
3. 订阅（subscribe）

<https://juejin.im/post/5b17560e6fb9a01e2862246f>
## 高质量文档

 1. [RxJava2 只看这一篇文章就够了](<https://juejin.im/post/5b17560e6fb9a01e2862246f>)

 2. [RxJava 2.x 使用详解(一) 快速入门](<https://maxwell-nc.github.io/android/rxjava2-1.html>)

 3. [最适合使用RxJava处理的四种场景]([https://www.daidingkang.cc/2017/12/12/%E6%9C%80%E9%80%82%E5%90%88%E4%BD%BF%E7%94%A8RxJava%E5%A4%84%E7%90%86%E7%9A%84%E5%9B%9B%E7%A7%8D%E5%9C%BA%E6%99%AF/](https://www.daidingkang.cc/2017/12/12/最适合使用RxJava处理的四种场景/))

 4. [RxJava 从入门到放弃再到不离不弃](<https://www.daidingkang.cc/2017/05/19/Rxjava/>)（细节很到位，不过有些内容是 RxJava 1.0 配合第五篇理解）
  5. [Android：RxJava 2.0 到底更新了什么？（含 RxJava 1.0的更新使用）](https://juejin.im/entry/5a5bfbd1518825733d6907d6)



2 要点：

上面可以看到FlowableSubscriber中我们只关心onNext方法，其他方法如果我们我们不需要。



## 思考

被观察者就是生产者

而观察者是消费者，被观察者则通过订阅方式让一个或以上的观察者来观察它产生的事件。

以数据流驱动事件编程思想。



为什么自己会有用 RxJava 通讯的想法。。。。。。。。？



### 内存泄漏

`unsubscribe()`: 这是 `Subscriber` 所实现的另一个接口 `Subscription` 的方法，用于取消订阅。在这个方法被调用后，`Subscriber` 将不再接收事件。一般在这个方法调用前，可以使用 `isUnsubscribed()` 先判断一下状态。 `unsubscribe()` 这个方法很重要，因为在 subscribe() 之后， `Observable` 会持有 `Subscriber` 的引用，这个引用如果不能及时被释放，将有内存泄露的风险。所以最好保持一个原则：要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）调用 unsubscribe() 来解除引用关系，以避免内存泄露的发生。



### 一些问题

- Observable  发射3个数字，Observable   每次新订阅  Observer ，后续的 Observer 是否会接收到 1 2 3
  - 猜测，是的。需验证





## 笔记



### 事件与操作符

| 事件种类     | **作用**                                                     |
| ------------ | ------------------------------------------------------------ |
| onNext()     | 发送该事件时，观察者会回调 onNext() 方法                     |
| onError()    | 发送该事件时，观察者会回调 onError() 方法，当发送该事件之后，其他事件将不会继续发送 |
| onComplete() | 发送该事件时，观察者会回调 onComplete() 方法，当发送该事件之后，其他事件将不会继续发送 |



| 常用操作符 | 说明                                                         |
| ---------- | ------------------------------------------------------------ |
| create     | 创建一个被观察者                                             |
| map        | 用来把把一个事件转换为另一个事件，可链式调用                 |
| flatMap    | 同上，但是返回的是 `Observable`对象，并且这个 `Observable` 对象并不是被直接发送到了 `Subscriber` 的回调方法中 |
| filter     | 输出和输入相同的元素，并且会过滤掉那些不满足检查条件的。返回布尔型，条件为 false 被过滤 |
| take       | 最大发射的数量                                               |





### 线程控制(Scheduler)

使用 RxJava，你可以使用 `subscribeOn()`指定观察者代码运行的线程，使用`observerOn()`指定订阅者运行的线程





### Scheduler 的 API

在RxJava 中，`Scheduler` ——调度器，相当于线程控制器，`RxJava` 通过它来指定每一段代码应该运行在什么样的线程。`RxJava` 已经内置了几个 `Scheduler` ，它们已经适合大多数的使用场景：

- Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。
- Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。
- Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。
- Schedulers.computation(): 计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
- 另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。



### RxJava 1.0 与 RxJava  2.0 的接口名变化

- 对于 `ActionX`接口名的更改

| RxJava 1          | RxJava 2                            |
| ----------------- | ----------------------------------- |
| Action0           | Action                              |
| Action1           | Consumer（接收1个参数）             |
| Action2           | BiConsumer （接收2个参数）          |
| ActionN           | Consumer<Object[]> （接收多个参数） |
| Action3 - Action9 | 不再使用                            |

- 对于 `FuncX`接口名的更改

| RxJava 1      | RxJava 2                  |
| ------------- | ------------------------- |
| Func          | Function （用于变换对象） |
| Func2         | BiFunction                |
| Func3 - Func9 | Function3 - Function9     |
| FuncN         | Function<Object[], R>     |

-  操作符的改变

| RxJava 1.0               | RxJava 2.0                              |
| ------------------------ | --------------------------------------- |
| first（）                | 改名为：firstElement（）                |
| first(Func1)             | 弃用，改用为：filter(predicate).first() |
| firstOrDefault(T)        | 改名为：first（T）                      |
| firstOrDefault(Func1, T) | 改名为：first（T）                      |

# Retrofit2 学习
#  Retrofit2 使用



## 安装与使用



### 官网

[官方 Github 地址](<https://square.github.io/retrofit/>)

```
implementation 'com.squareup.retrofit2:retrofit:2.5.0'
```

注意：Retrofit requires at minimum Java 7 or Android 2.3.



### 添加网络权限

```java
<uses-permission
android:name="android.permission.INTERNET"/>
```

### 文章列表

* [Retrofit2 的简单使用 ](https://juejin.im/post/5a335d175188250d407f65e9)
* [全新的网络加载框架Retrofit2，上位的小三](https://www.daidingkang.cc/2016/06/17/Retrofit2-network-framework-parsing/)

### 缓存

[Retrofit2.0+okhttp3缓存策略](<https://www.jianshu.com/p/412157e236ad>)

# 总结

### 正确添加方式

```
implementation 'com.squareup.retrofit2:retrofit:2.5.0'
implementation "com.squareup.retrofit2:converter-gson:2.5.0"
```

### 不是默认以Gson解析，需要 addConverterFactory

```
Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://api.douban.com/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
```

### 与 RxJava2 结合

导入依赖

```
implementation 'com.squareup.retrofit2:adapter-rxjava2:2.5.0'
```

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.waqi.info/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //添加这句
                .build();
```

###


# MVP 模式学习

## 文章

- [Android MVP 十分钟入门！](<https://juejin.im/post/58870cc2128fe1006c46e39c#heading-3>) （有 MVC 与 MVP代码对比，讲的通俗易懂）

- [Android MVP架构从入门到精通-真枪实弹](https://juejin.im/post/5bf787d5e51d450c487d06dd)（拥有 MVP 项目经验的可以看）

- [浅谈 MVC、MVP 和 MVVM 架构模式](https://draveness.me/mvx)（发展历史，区别，适用范围）



## 思考

假设一个场景是自动更新，这个自动更新逻辑应该是写在 Model 里 ，而  Presenter 负责去调用 Model 具体的自动更新逻辑。

没有 View 的操作，那谁通知 Presenter 去执行这个动作呢？



### Model 层

要求实现 IModel 接口

```java
public class DownloadModel implements IModel
```



Model 有参构造器中传入 Presenter，让 Model 持有 Presenter 引用。

```java
 public DownloadModel(IDowndownPresenter IDowndownPresenter) {
        mIDowndownPresenter = IDowndownPresenter;
    }
```

### Presenter 层

要求实现 IPresenter接口

```java
public class DownloadPresenter implements IPresenter {
```



Presenter 有参构造器中传入 View ， 让 Presenter 持有 View 的引用，再实例化并持有一个 Model  对象。

这样 Presenter 就同时拥有 Model 与 View  的引用，这样就起到沟通两者的作用。

```java
 public DownloadPresenter(IDownloadView IDownloadView) {
        mIDownloadView = IDownloadView;
        mIDownloadModel = new DownloadModel(this);
    }
```

### View 层

要求实现 IView 接口

```java
public class MVPActivity extends AppCompatActivity implements IView
```

View 实例化一个 Presenter 并持有引用。

```java
private void init() {
        mDownloadPresenter = new DownloadPresenter(this);
        ....
        }
```




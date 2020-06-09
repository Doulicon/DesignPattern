# 1. synchronized简介

来源（https://blog.csdn.net/zjy15203167987/article/details/82531772）

1.为什么要使用synchronized

在并发编程中存在线程安全问题，主要原因有：1.存在共享数据 2.多线程共同操作共享数据。关键字synchronized可以保证在同一时刻，只有一个线程可以执行某个方法或某个代码块，同时synchronized可以保证一个线程的变化可见（可见性），即可以代替volatile。

2.实现原理

synchronized可以保证方法或者代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时它还可以保证共享变量的内存可见性

3.synchronized的三种应用方式

Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

普通同步方法（实例方法），锁是当前实例对象 ，进入同步代码前要获得当前实例的锁
静态同步方法，锁是当前类的class对象 ，进入同步代码前要获得当前类对象的锁
同步方法块，锁是括号里面的对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。
4.synchronized的作用

Synchronized是Java中解决并发问题的一种最常用最简单的方法 ，他可以确保线程互斥的访问同步代码


**5.举栗子**

**一、synchronized作用于实例方法**

①多个线程访问同一个对象的同一个方法

```
public class synchronizedTest implements Runnable {
    //共享资源
    static int i =0;
    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase(){
        i++;
    }
    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        synchronizedTest test = new synchronizedTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

```

结果：

![这里写图片描述](https://img-blog.csdn.net/20180908161541502?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pqeTE1MjAzMTY3OTg3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

分析：当两个线程同时对一个对象的一个方法进行操作，只有一个线程能够抢到锁。因为一个对象只有一把锁，一个线程获取了该对象的锁之后，其他线程无法获取该对象的锁，就不能访问该对象的其他synchronized实例方法，但是可以访问非synchronized修饰的方法

②一个线程获取了该对象的锁之后，其他线程来访问其他synchronized实例方法现象 举栗


```java
public class SynchronizedTest {
    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();

        new Thread(test::method1).start();

        new Thread(test::method2).start();
    }

}

```

结果：

![这里写图片描述](https://img-blog.csdn.net/20180908163622574?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pqeTE1MjAzMTY3OTg3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

分析：可以看出其他线程来访问synchronized修饰的其他方法时需要等待线程1先把锁释放

③一个线程获取了该对象的锁之后，其他线程来访问其他非synchronized实例方法现象 举栗
去掉②中方法二的synchronized

```java
public class SynchronizedTest {
    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();

        new Thread(test::method1).start();
        new Thread(test::method2).start();
    }

}
```

结果：

![这里写图片描述](https://img-blog.csdn.net/20180908163949972?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pqeTE1MjAzMTY3OTg3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

分析：当线程1还在执行时，线程2也执行了，所以当其他线程来访问非synchronized修饰的方法时是可以访问的

④当多个线程作用于不同的对象

```
public class SynchronizedTest {
    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SynchronizedTest test1 = new SynchronizedTest();
        final SynchronizedTest test2 = new SynchronizedTest();

        new Thread(test1::method1).start();

        new Thread(test2::method2).start();
    }

}

```

结果：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200305113103511.png)

分析：因为两个线程作用于不同的对象，获得的是不同的锁，所以互相并不影响

**二、synchronized作用于静态方法**

```
public class synchronizedTest implements Runnable {
    //共享资源
    static int i =0;
    /**
     * synchronized 修饰实例方法
     */
    public static synchronized void increase(){
        i++;
    }
    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new synchronizedTest());
        Thread t2 = new Thread(new synchronizedTest());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

```

结果：

![这里写图片描述](https://img-blog.csdn.net/20180908173307847?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pqeTE1MjAzMTY3OTg3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

分析：由例子可知，两个线程实例化两个不同的对象，但是访问的方法是静态的，两个线程发生了互斥（即一个线程访问，另一个线程只能等着），因为静态方法是依附于类而不是对象的，当synchronized修饰静态方法时，锁是class对象。

**三、synchronized作用于同步代码块**

为什么要同步代码块呢？在某些情况下，我们编写的方法体可能比较大，同时存在一些比较耗时的操作，而需要同步的代码又只有一小部分，如果直接对整个方法进行同步操作，可能会得不偿失，此时我们可以使用同步代码块的方式对需要同步的代码进行包裹，这样就无需对整个方法进行同步操作了。

```
public class synchronizedTest implements Runnable {
    static synchronizedTest instance=new synchronizedTest();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(instance){
            for(int j=0;j<10000;j++){
                i++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance);
        Thread t2=new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
```

结果：

![这里写图片描述](https://img-blog.csdn.net/20180908174315946?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pqeTE1MjAzMTY3OTg3/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)



分析：将synchronized作用于一个给定的实例对象instance，即当前实例对象就是锁对象，每次当线程进入synchronized包裹的代码块时就会要求当前线程持有instance实例对象锁，如果当前有其他线程正持有该对象锁，那么新到的线程就必须等待，这样也就保证了每次只有一个线程执行i++;操作。当然除了instance作为对象外，我们还可以使用this对象(代表当前实例)或者当前类的class对象作为锁，如下代码：

```
//this,当前实例对象锁
synchronized(this){
    for(int j=0;j<1000000;j++){
        i++;
    }
}

//class对象锁
synchronized(AccountingSync.class){
    for(int j=0;j<1000000;j++){
        i++;
    }
}
```

————————————————
版权声明：本文为CSDN博主「淘小笛」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/zjy15203167987/java/article/details/82531772
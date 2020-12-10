package com.zhangjp.dataStrAlgo.juc;

import java.util.concurrent.Semaphore;

/*
*
* 1115. 交替打印FooBar
我们提供一个类：

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。

请设计修改程序，以确保 "foobar" 被输出 n 次。



示例 1:

输入: n = 1
输出: "foobar"
解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
示例 2:

输入: n = 2
输出: "foobarfoobar"
解释: "foobar" 将被输出两次。
* */
public class FooBar {

    private int n;
    private Semaphore foo = new Semaphore(1); // foo线程先执行
    private Semaphore bar = new Semaphore(0); // bar线程后执行

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }





    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        // 两个线程交替打印
        new Thread(() -> {
            try {
                fooBar.foo(new PrintFoo());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 两个线程交替打印
        new Thread(() -> {
            try {
                fooBar.bar(new PrintBar());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("= = = = = main end = = = = = ");
    }
}

class PrintBar implements Runnable{

    @Override
    public void run() {
        System.out.println("bar");
    }
}

class PrintFoo implements Runnable{

    @Override
    public void run() {
        System.out.println("foo");
    }
}

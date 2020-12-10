package com.zhangjp.dataStrAlgo.juc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {

    private int n;
    private Semaphore zeroSem,evenSem,oddSem;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSem = new Semaphore(1); // 打印0
        evenSem = new Semaphore(0); // 打印偶数
        oddSem = new Semaphore(0); // 打印奇数
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1;i <= n;i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if(i%2 == 0){
                evenSem.release();
            }else{
                oddSem.release();
            }

        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2;i <= n;i+=2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1;i <= n;i+=2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }


    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        IntConsumer intConsumer = System.out::print;
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

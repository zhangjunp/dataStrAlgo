package com.zhangjp.dataStrAlgo.juc.basic;

public class ThreadD {


    public static void main(String[] args) throws InterruptedException {
        RunnableTest1 runnable = new RunnableTest1();
        Thread t1  = new Thread(runnable);
        ThreadTest1 t2 = new ThreadTest1();
        t1.start();
        t2.start();
        t1.interrupt();
        Thread.sleep(1000);
        runnable.stop();
    }


    // 为什么线程的中断都采用通信模式呢
    private static class RunnableTest1 implements Runnable {
        private volatile boolean stopFlag = false;
        @Override
        public void run() {
            System.out.println("my runnable run ……");
            while (!stopFlag) {
                System.out.println("i am working……");
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();// 这种方式不是很友好，如果想要停止此线程，会导致无法正常停止
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("my runnable stop ……");
        }

        public void stop () {
            stopFlag = true;
        }
    }


    private static class ThreadTest1 extends Thread{

        @Override
        public void run() {
            System.out.println("my thread run ……");
        }
    }
}

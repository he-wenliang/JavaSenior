package com.hewl.exer;

/**
 * 创建两个分线程，其中一个线程遍历100内偶数，一个遍历100内奇数
 *
 * @author 何文亮
 * @date 2021-03-14
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //1创建子类对象
//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();
//        m1.start();
//        m2.start();
        //2创建Thread类的匿名子类的方法
        new Thread() {
            @Override
            public void run() {
                class MyThread1 extends Thread {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            if (i % 2 == 0) {
                                System.out.println(Thread.currentThread().getName() + ":" + i);
                            }
                        }
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                class MyThread1 extends Thread {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i++) {
                            if (i % 2 != 0) {
                                System.out.println(Thread.currentThread().getName() + ":" + i);
                            }
                        }
                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
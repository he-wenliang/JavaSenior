package com.hewl.java;

/**
 * 多线程的创建1：继承Thread类
 *  1创建一个继承Thread的子类
 *  2重写Thread中的run()        -->声明此线程执行的操作
 *  3创建子类的对象
 *  3通过对象调用start()方法
 *
 *  eg:遍历100内的所有偶数
 *
 * @author 何文亮
 * @date 2021-03-14
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        //1启用当前线程；2调用当前线程的run()方法
        //如下操作仍然在main线程中执行
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***********main()**********");
            }
        }
    }

}

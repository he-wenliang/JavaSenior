package com.hewl.java;

/**
 * 测试Thread常用方法
 *
 * @author 何文亮
 * @date 2021-03-14
 *
 * 线程的优先级
 * 1.
 *  MAX_PRIORITY:10
 *  MIN_PRIORITY:1
 *  NORM_PRIORITY:5
 * 2.如何获取和设置
 * getPriority():获取线程的优先级
 * setPriority(int p):设置线程的优先级
 *      说明：从概率上讲，高优先级的线程可能会被先执行
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

                //1s
//                try {
//                    //线程执行到这时，停止1s(单位毫秒)
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//            if (i % 20 == 0) {
//                this.yield();//释放当前cpu的执行
//            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");
//        h1.setName("线程1");

        //设置多线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":"+ i);
            }
//            if(i == 20){
//                try {
//                    h1.join();//在线程a中调用线程b的join()方法，此时线程a就进入阻塞状态，直到b执行完以后
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        //判断线程是否还存在
        System.out.println(h1.isAlive());

    }
}

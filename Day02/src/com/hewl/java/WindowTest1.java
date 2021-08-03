package com.hewl.java;

/**
 * 例子：三个窗口买票，总票数100,使用实现Runable接口的方式
 * 出现重票和错票--->线程安全问题
 *
 * 某个线程操作车票的过程中，还未完成，有其他线程也参与进来
 * 解决方法：一个线程操作的时候，其他线程不能参与进来；直到操作完
 * 在java中，通过同步机制来解决
 * <p>
 * synchronized(同步监视器){
 *      //需要同步的代码：操作共享数据的代码
 * }
 * 同步监视器:锁 任何一个类的对象都可以充当（解决了线程安全问题）
 * 多个线程必须共用同一把锁
 *  补充：在实现Runnable接口常见多线程的方法中，可以考虑this充当同步监视器
 *
 * 操作代码时，只能有一个线程操作，其他线程等待；相当与单线程执行，效率低
 * @author 何文亮
 * @date 2021-03-14
 */
class Window1 implements Runnable {

    private int ticket = 100;
    //Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {

    public static void main(String[] args) {

        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

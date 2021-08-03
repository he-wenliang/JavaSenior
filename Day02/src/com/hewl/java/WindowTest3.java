package com.hewl.java;

/**
 * 使用同步方法解决Runnable接口的线程安全问题
 *
 * 总结：
 * 1.同步方法仍然使用到同步监视器，只是不需要我们显式声明
 * 2.非静态的同步方法，同步监视器：this
 *   静态的同步方法，同步监视器：当前类本身
 *
 * @author 何文亮
 * @date 2021-03-17
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        show();
    }

    private synchronized void show() {//同步监视器this
        while (true) {
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

public class WindowTest3 {

    public static void main(String[] args) {

        Window3 w = new Window3();

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

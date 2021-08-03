package com.hewl.java;

/**
 * 使用同步方法解决继承Thread类中的线程安全问题
 *
 * @author 何文亮
 * @date 2021-03-17
 */
class Window4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {//同步监视器;window4.class
    //private synchronized void show() {//同步监视器t1,t2,t3(错误的)
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {

    public static void main(String[] args) {

        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

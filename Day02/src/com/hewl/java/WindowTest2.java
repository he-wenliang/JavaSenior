package com.hewl.java;

/**
 * 使用继承Thread类的方式
 * <p>
 * 使用同步代码块解决继承Thread类的线程安全问题
 *
 * 说明：慎用this充当同步监视器，可以考虑当前类
 * @author 何文亮
 * @date 2021-03-17
 */
class Window2 extends Thread {

    private static Object obj = new Object();
    private static int ticket = 100;

    @Override
    public void run() {
        //正确的
        //synchronized (obj) {
        synchronized (Window2.class) {//Class claszz = Window2.class;
        //错误的：this代表t1.t2.t3三个对象
        //synchronized(this){

            while (true) {

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：买票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

public class WindowTest2 {

    public static void main(String[] args) {

        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

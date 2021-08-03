package com.hewl.java;

/**
 * 例子：三个窗口买票，总票数100,使用实现Runable接口的方式
 *
 * @author 何文亮
 * @date 2021-03-14
 */
class Window1 implements Runnable {

    private  int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket);
                ticket--;
            }else{
                break;
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
    }
}

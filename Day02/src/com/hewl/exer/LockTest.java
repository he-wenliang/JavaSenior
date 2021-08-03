package com.hewl.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁
 *
 * 1.面试题：synchronized 与 Lock有什么异同？
 *  同：解决线程安全问题
 *  异：synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 *      lock需要手动去启动同步（lock()）,结束同步也需要手动执行（unlock()）
 * 2.优先顺序：
 *  Lock -->同步代码块-->同步方法
 *
 * @author 何文亮
 * @date 2021-03-17
 */
class Window implements Runnable {

    private int tickets = 100;
    //1.实例化

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try{
                lock.lock();
                //2.调用lock()方法

                if (tickets > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + tickets);
                    tickets--;
                }else{
                    break;
                }
            }finally{
                //3.调用解锁方法:unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {

    public static void main(String[] args) {
        Window w = new Window();

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

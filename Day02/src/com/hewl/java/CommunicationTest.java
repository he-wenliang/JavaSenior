package com.hewl.java;

/**
 * 线程通信例子：使用两个线程交替打印1-100的数
 *  1.wait():一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 *  2.notify():一旦执行此方法，就会唤醒被wait的线程，若有多个线程被wait，就唤醒优先级最高的
 *  3.notifyAll():一旦执行此方法，就会唤醒所有被wait的线程
 *
 *  注意点：
 *  1.wait(),notify(),notifyAll()三个方法必须使在同步代码块或同步方法中
 *  2.他们的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现异常
 *  3.他们被定义在java.lang.Object类中
 *
 *  面试题：
 *  1.sleep()和wait()的异同：
 *      同：都使当前线程进入阻塞状态
 *      异： 1.声明的位置不同：Thread类中声明sleep()，Object类中声明wait()
 *          2.调用的要求不同：sleep()可以在任何需要的场景下使用.wait()必须使用在同步代码块或同步方法中
 *          3.关于是否释放同步监视器：若都使用在同步代码块或同步方法中，sleep()不会释放锁，而wait()h会释放同步监视器
 *
 * @author 何文亮
 * @date 2021-03-20
 */
class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {

                //唤醒wait的线程
                this.notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使得调用如下方法的线程进入阻塞状态
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();


    }
}

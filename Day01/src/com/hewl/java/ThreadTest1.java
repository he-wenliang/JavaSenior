package com.hewl.java;

/**
 * 创建多线程的方式二：Runable接口
 * 1.创建一个实现Runable接口的类
 * 2.实现类去实现Runable中的抽象方法L:run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()方法
 *
 *
 * 比较创建线程的两种方式：
 *  开发者，优先选择实现Runnable接口的方式
 *  原因：1.实现的方式没有类的单继承性的局限性
 *       2.实现的方式更适合实现多个线程有共享数据的情况
 *  联系：1.Thread也实现Runnable接口
 *  相同点：两种方式都需要重写run()方法，将线程需要实现的操作写进run方法中
 *
 * @author 何文亮
 * @date 2021-03-14
 */
//1.创建一个实现Runable接口的类
class MThread implements Runnable {
    //2.实现类去实现Runable中的抽象方法L:run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MThread mThread = new MThread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        //5.通过Thread类的对象调用start()方法
        t1.start();

        //重新启动一个线程
        Thread t2 = new Thread(mThread);
        t2.start();
    }
}

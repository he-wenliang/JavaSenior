package com.hewl.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程方式四：使用线程池
 *
 * @author 何文亮
 * @date 2021-03-20
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        //设置线程池的属性
        //System.out.println(service.getClass());
        //service1.setCorePoolSize(15);
        //service1.setKeepAliveTime(100);

        //2.执行指定的线程操作，需要实现Runnable接口或Callable()接口实现类的对象
        //适合使用于Runnable
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
        //适合使用于Callable
        //service.submit();
        //3.关闭线程池
        service.shutdown();
    }
}

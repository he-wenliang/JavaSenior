package com.hewl.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author wen
 * @date 2021-07-21
 */
public class LambdaTest {
    @Test
    public void test(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        Runnable r2 = () ->  System.out.println("我爱吃糖");

        r2.run();
    }

    //这是单行注释
    /*
    这是多行注释

    */
    @Test
    public void test1(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = com1.compare(12, 21);
        System.out.println(compare);
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int compare2 = com1.compare(12, 21);
        System.out.println(compare2);

        //方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com1.compare(12, 21);
        System.out.println(compare3);
    }
}

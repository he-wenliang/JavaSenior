package com.hewl.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wen
 * @date 2021-06-08
 */
public class GeneticTest1 {
    @Test
    public void test(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Onject 类型
        //如果定义类为泛型，建议实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ABC");

        //建议带上泛型
        Order<String> order1 = new Order<String>("OrderA",1001,"Orderaaaaa");
        order1.setOrderT("AA:Hello");

    }
    @Test
    public void test1(){
        SubOrder sub1 = new SubOrder();
        //由于子类继承了带泛型的父类，则实例化子类对象时，不再需要指明泛型。
        sub1.setOrderT(125);
        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2.....");
    }
    @Test
    public void test2(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

    }
    //测试泛型方法
    @Test
    public void test3(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法的调用，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayList(arr);
        System.out.println(list);
    }
}

package com.hewl.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author 何文亮
 * @date 2021-06-05
 */
public class ForTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        //方法一：遍历
//        Iterator iterator = coll.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        //方法二：
        for(Object obj : coll){
            System.out.println(obj);
        }
    }
    @Test
    public void test1(){
        int [] arr = new int[]{1,2,3,5,6,8};

        for(int i:arr){
            System.out.println(i);
        }
    }
    //练习题
    @Test
    public void test2(){
        String[] arr = new String[]{"MM","MM","MM"};
        //普通循环
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";
//        }
        //增强for循环
        for(String s : arr){
            s = "GG";
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

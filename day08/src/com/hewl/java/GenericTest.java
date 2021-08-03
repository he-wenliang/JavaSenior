package com.hewl.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * @author wen
 * @date 2021-06-07
 */
public class GenericTest {
    //在集合中考虑使用泛型:HashMap为例
    @Test
    public void test2(){
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //jdk7新特性：类型推断
        HashMap<String, Integer> map = new HashMap<>();
        map.put("AA",56);
        map.put("AB",55);
        map.put("AC",76);
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "-------" + value);
        }
    }
    //在集合中考虑使用泛型:ArrayList为例
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(-95);
        list.add(56);
        //在编译时就会进行类型检查，保证数据的安全性
//        list.add("Name");
        //方式一：
//        for (Integer o:list) {
//            //避免强转，
//            int s = o;
//            System.out.println(s);
//        }
        //方式二:
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(12);
        list.add(66);
        list.add(33);
        //类型不安全
        list.add("Name");
        for (Object score : list) {
            //强转时，可能出现ClassCastException
            int stuScore = (Integer)score;
            System.out.println(stuScore);
        }
    }
}

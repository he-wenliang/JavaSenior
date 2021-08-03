package com.hewl.java;

import org.junit.Test;

import java.util.*;

/**
 * @author wen
 * @date 2021-06-06
 */
public class TreeMapTest {
    //定制排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配....");
            }
        });

        User u1 = new User("Judy",18);
        User u2 = new User("Hans",19);
        User u3 = new User("Andy",20);
        User u4 = new User("Jerry",26);

        map.put(u1,95);
        map.put(u2,94);
        map.put(u3,86);
        map.put(u4,93);

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "-------->" + entry.getValue());
        }
    }
    //自然排序
    @Test
    public void test(){
        TreeMap map = new TreeMap();
        User u1 = new User("Judy",18);
        User u2 = new User("Hans",19);
        User u3 = new User("Andy",20);
        User u4 = new User("Jerry",18);

        map.put(u1,95);
        map.put(u2,94);
        map.put(u3,86);
        map.put(u4,93);

        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "-------->" + entry.getValue());
        }
    }
}

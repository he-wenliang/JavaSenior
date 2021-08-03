package com.hewl.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 何文亮
 * @date 2021-06-05
 */
public class ListTest {
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("aa");
        list.add(123);
        list.add(new Person("Andy",18));

        //void add(int index,Objec ele):在index位置插入ele元素
        list.add(1,"BB");
        System.out.println(list);
        //boolean addAll(int index,Collection eles):从index位置开始将eles中所有元素添加
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);//6+3
        System.out.println(list.size());
        //Object get(int index):获取指定位置元素
        System.out.println(list.get(0));
        //int indexOf(Onject obj):返回obj在当前集合中首次出现的位置,若不存在，返回-1
        int index = list.indexOf(456);
        System.out.println(index);
        //int lastIndexOf(Onject obj):返回obj在当前集合中末次出现的位置,若不存在，返回-1
        int i = list.lastIndexOf(123);
        System.out.println(i);
        //Object remove(int index):移除指定index位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        //Onject set(int index,Object obj):设置指定index元素为obj
        list.set(1,"CC");
        System.out.println(list);
        //List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集
        System.out.println(list.subList(2, 4));
    }
}

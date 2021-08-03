package com.hewl.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * collections:操作Collection，Map的工具类
 *
 * @author wen
 * @date 2021-06-06
 */
public class CollectionsTest {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(36);
        list.add(99);
        list.add(106);
        list.add(65);
        list.add(45);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest,list);
        System.out.println(dest);
        //返回的list1是线程安全的
        List list1 = Collections.synchronizedList(list);

    }

    @Test
    public void test(){
        List list = new ArrayList();
        list.add(36);
        list.add(99);
        list.add(99);
        list.add(99);
        list.add(106);
        list.add(65);
        list.add(45);
        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list,0,4);
        int fre = Collections.frequency(list, 99);
        System.out.println(fre);
        System.out.println(list);
    }

}

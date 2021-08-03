package com.hewl.java;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author 何文亮
 * @date 2021-05-31
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("Andy", 20);
//        coll.add(p);
        coll.add(new Person("Tom",20));
        //contains(Object obj):判断当前集合是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("Tom",20)));
        //containsAll()
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll1.containsAll(coll1));
    }
    @Test
    public void test2(){
        //3.remove(Object obj)
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Tom",20));
        System.out.println(coll.remove(123));
        System.out.println(coll);
        //4.removeAll(Collection coll)
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Tom",20));
        //5.retainAll(Collection coll)
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);
        //6.equals(Object obj)
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("Tom",20));

        System.out.println(coll.equals(coll1));
    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Tom",20));
        //7.hasCode()
        System.out.println(coll.hashCode());
        //8.集合-----> 数组：Object[] toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //数组 -------> 集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2
        //9.iterator():IteratorTest

    }
}

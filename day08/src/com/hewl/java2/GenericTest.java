package com.hewl.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wen
 * @date 2021-06-08
 */
public class GenericTest {
    //? extends Person
    //? super Person

    @Test
    public void test3(){
        List<? extends Person> list1 = null;//<=
        List<? super Person> list2 = null;//>=

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        list1 = list4;
        Person p = list1.get(0);
        //编译不过
//        Student s = list1.get(0);
        list2 = list4;
        Object o = list2.get(0);

    }

    @Test
    public void test2(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;

        list = list1;
        list = list2;

        print(list1);
        print(list2);
        //添加（写入）：对于list<?>就不能向其内部添加数据，除了null
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
//        list.add("AA");
        list.add(null);
        //获取（读取）:允许读取数据，读取的类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> llist){
        Iterator<?> iterator = llist.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
    @Test
    public void test1(){
        List<String> list1 = null;
        AbstractList<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
        List<String> list4 = new ArrayList<>();
    }

    @Test
    public void test(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr = null;
        String[] arr1 = null;
        arr = arr1;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1与list2不具有子父类关系
//        list1 = list2;
        show(list1);

        show1(list2);
    }
    public void show1(List<String> list){

    }
    public void show(List<Object> list){

    }
}

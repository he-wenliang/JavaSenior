package com.hewl.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 何文亮
 * @date 2021-06-05
 */
public class TreeSetTest {
    @Test
    public void test(){
        TreeSet set = new TreeSet();
        //不能添加不同类的对象
//        set.add(123);
//        set.add(654);
//        set.add("AA");
//        set.add(new Person("Guo",16));
//        set.add(123);
//        set.add(98);
//        set.add(-65);
//        set.add(0);
        set.add(new User("Guo",16));
        set.add(new User("He",20));
        set.add(new User("Zhou",17));
        set.add(new User("Andy",19));
        set.add(new User("Andy",23));
        set.add(new User("Yal",16));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test1(){
        Comparator com = new Comparator() {
            //按照年龄从小到大
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入数据类型不一致");
                }
            }
        };
        TreeSet set = new TreeSet(com);

        set.add(new User("Guo",16));
        set.add(new User("He",20));
        set.add(new User("Zhou",17));
        set.add(new User("Andy",19));
        set.add(new User("Andy",23));
        set.add(new User("Yal",16));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

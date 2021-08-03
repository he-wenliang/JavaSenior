package com.hewl.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author 何文亮
 * @date 2021-05-12
 */
public class CollectionTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        //add(Object o)
        coll.add("aa");
        coll.add("bb");
        coll.add(123);//自动装箱
        coll.add(new Date());
        //size()
        int size = coll.size();
        System.out.println(size);
        //addall()
        Collection coll1 = new ArrayList();
        coll1.add("dd");
        coll1.add(456);
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);
        //clear():清空集合
        coll.clear();
        //isEmpty():是否有元素
        System.out.println(coll.isEmpty());

    }
}

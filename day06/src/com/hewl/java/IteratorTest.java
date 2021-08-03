package com.hewl.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * 集合元素的遍历,使用Iterator接口
 *
 * @author 何文亮
 * @date 2021-06-05
 */
public class IteratorTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator = coll.iterator();
        //方式一：
        //System.out.println(iterator.next());
        //方式二：
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }
        //方式三：推荐
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        //remove:Tom
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        //遍历
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

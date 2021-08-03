package com.hewl.java;

import org.junit.Test;

import java.util.*;

/**
 * @author 何文亮
 * @date 2021-06-06
 */
public class MapTest {
    @Test
    public void test3() {

        Map map = new HashMap();
        map.put("AA", 21);
        map.put("BB", 31);
        map.put("FF", 52);
        //Set keyset():返回所有key构成的set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //Collection values():返回所有value构成的collection集合
        Collection values = map.values();
        //System.out.println(values);
        for (Object obj: values) {
            System.out.println(obj);
        }
        //Set entryset():返回所有key-value对构成的set集合
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while(iterator1.hasNext()){
            Object o = iterator1.next();
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + "-------->" + entry.getValue());
        }
        //方法二:
        Set setkey = map.keySet();
        Iterator iterator2 = setkey.iterator();
        while(iterator.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "========" + value);
        }
    }
    @Test
    public void test2() {

        Map map = new HashMap();
        map.put("AA", 21);
        map.put("BB", 31);
        map.put("FF", 52);
        //Object get(Object key):
        System.out.println(map.get("BB"));
        //boolean containsKey()
        boolean cc = map.containsKey("CC");
        System.out.println(cc);
        //boolean containsValue()
        System.out.println(map.containsValue(21));
        //int size()
        System.out.println(map.size());
        //boolean isEmpty()
        System.out.println(map.isEmpty());
        //boolean equals()

    }
    @Test
    public void test1(){
        //添加
        Map map = new HashMap();
        map.put("AA",21);
        map.put("BB",31);
        map.put("FF",52);
        //修改
        map.put("AA",99);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("CC",65);
        map1.put(36,65);
        map.putAll(map1);
        System.out.println(map);

        //remove(Onject key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);
        //clear()
        map.clear();
        System.out.println(map.size());
    }
    @Test
    public void test(){
        Map map = new HashMap();

        map = new LinkedHashMap();
        map.put(null,null);
        map.put(12,"AA");
        map.put(14,"CC");
        map.put(13,"BB");
        System.out.println(map);
    }
}

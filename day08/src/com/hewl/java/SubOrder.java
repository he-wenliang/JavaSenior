package com.hewl.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wen
 * @date 2021-06-08
 */
public class SubOrder extends Order<Integer>{
    //suborder不是泛型类
    public static <E> List<E> copyFromArrayList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e:arr){
            list.add(e);
        }
        return list;
    }
}

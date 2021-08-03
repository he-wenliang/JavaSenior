package com.hewl.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 1)正常情况下，对象只能 == 或者 ！= ，不能使用大于或小于的
 *   在开发中则需要对多个对象进行排序（比较大小）使用两个接口中的其中一个
 *   Comparable  Comparator
 *
 * @author 何文亮
 * @date 2021-05-09
 */
public class CompareTest {
    //String 包装类都实现了Comparable接口重写了compareTo(obj)方法;从小到大
    //重写规则：
    //  当前对象this如果大于形参对象obj，返回正整数；
    //                小于               负整数
    //                                     0
    @Test
    public void test(){
        String [] arr = {"AA","JJ","GG","EE","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void GoodsTest(){
        Goods[] arrs = new Goods[5];
        arrs[0] = new Goods("lenovoMouse",35);
        arrs[1] = new Goods("xioamiMouse",95);
        arrs[2] = new Goods("dellMouse",125);
        arrs[3] = new Goods("huaweiMouse",65);
        arrs[4] = new Goods("microsoftMouse",95);

        Arrays.sort(arrs);
        System.out.println(Arrays.toString(arrs));
    }
    @Test
    public void test1(){
        String [] arr = {"AA","JJ","GG","EE","DD"};
        Arrays.sort(arr, new Comparator() {
            //字符串从大到小排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                //return 0;
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void GoodsTest1(){

        Goods[] arrs = new Goods[6];
        arrs[0] = new Goods("lenovoMouse",35);
        arrs[1] = new Goods("xioamiMouse",95);
        arrs[3] = new Goods("dellMouse",125);
        arrs[2] = new Goods("xioamiMouse",65);
        arrs[4] = new Goods("huaweiMouse",65);
        arrs[5] = new Goods("microsoftMouse",95);

        Arrays.sort(arrs, new Comparator() {
            //指定商品比较大笑的方法:产品名称从低到高,再按照价格从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });
        System.out.println(Arrays.toString(arrs));
    }
}

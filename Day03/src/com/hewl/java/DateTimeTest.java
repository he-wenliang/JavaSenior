package com.hewl.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK8之前日期和时间的API
 *
 * @author 何文亮
 * @date 2021-04-29
 */
public class DateTimeTest {

    /**
     * java.util.Date
     *      /-----java.sql.Date
     * util.Date:
     * 1.两个构造器的使用:
     *      构造器1: Date()创建一个对应当前时间的Date对象
     *      构造器2：创建指定毫秒数的Date对象
     * 2.两个方法的使用：
     *  --->toString():显示当前的年 月 日 时 分 秒
     *  --->getTime():获取当前Date对象的时间戳
     * 3.java.sql.Date对应书库中的日期类型的变量
     *      如何实例化：
     *      将java.util.Date对象转化为java.sql.Date对象
     */
    @Test
    public void test2(){
        //构造器1: Date()创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());
        //构造器2：创建指定毫秒数的Date对象
        Date date2 = new Date(1619705345414L);
        System.out.println(date2);
        //创建Java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35487945465L);
        System.out.println(date3);
        //情况一:将java.util.Date对象转化为java.sql.Date对象
        //Date date4 = new java.sql.Date(56498564L);
        //java.sql.Date date5 = (java.sql.Date)date4;
        //情况二:
        Date date6 = new Date();
        //错误：java.sql.Date date5 = (java.sql.Date)date6;
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }
    @Test
    public void test1(){
        //时间戳：1970年1月1日0时0分0秒之间yi毫秒位单位的时间差
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
}

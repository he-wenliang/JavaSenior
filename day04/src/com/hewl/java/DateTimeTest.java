package com.hewl.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 何文亮
 * @date 2021-05-08
 */
public class DateTimeTest {

    @Test
    public void testSimpleDateTimeFormat() throws ParseException {
        //实例化 使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化  日期--->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析
        String str = "21-5-8 下午10:09";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //**********************************指定的方式进行格式化，调用带参的构造器
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析
        Date date2 = sdf1.parse("2022-05-08 10:16:25");
        System.out.println(date2);
    }
    //练习一：“2020-09-08”转换为java.sql.Date
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-02-28";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        //System.out.println(date);
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
    //日历类Calendar(抽象类)的使用
    @Test
    public void test1(){
        //1.实例化---1创建其子类（GregorianCalendar）的对象
        //       ---2调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        //System.out.println(calendar.getClass());
        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //getTime():日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}

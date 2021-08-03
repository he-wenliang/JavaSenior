package com.hewl.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author 何文亮
 * @date 2021-05-08
 */
public class JDK8DateTimeTest {
    @Test
    public void testDate(){
        Date date = new Date();
    }
    @Test
    public void test1(){
        //now():获取当前的日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        //LocalDateTime local使用频率高
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        //of():指定的年月日时分秒
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 10, 6, 13, 23, 45);
        System.out.println(localDateTime1);

        //getXxx():获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());
        //体现不可变性
        //withXxx():设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);
    }
    @Test
    public void test2(){
        //now():获取本初子午线对应的时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取对应的毫秒数
        long toEpochMilli = instant.toEpochMilli();
        System.out.println(toEpochMilli);
        //通过给定的毫秒数，获取Instant实例
        Instant instant1 = Instant.ofEpochMilli(1620538618022L);
        System.out.println(instant1);
    }
    @Test
    public void test3(){
        //DateTimeFormatter:格式化或者解析时间----------类似于SimpleDateFormatter
        //1
        DateTimeFormatter formatter= DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期 ------> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析:字符串 -------> 日期
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);
        //2本地化相关的格式：ofLocalDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);
        //*****************************************************************************
        //3自定义格式：ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);
        //解析
        TemporalAccessor parse1 = formatter3.parse("2021-05-09 02:41:20");
        System.out.println(parse);
    }
}

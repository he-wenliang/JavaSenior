package com.hewl.java;

import org.junit.Test;

/**
 * @author 何文亮
 * @date 2021-04-22
 *
 */

public class StringBufferBuilderTest {
    @Test
    public void test3(){
        //初始化
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
    /**
     * 总结：
     * 增：append(xxx)
     * 删：delete(int start, int end)
     * 改：setCharAt(int start, char ch) / replace(int start,int end,String str)
     * 查：charAt(int n)
     * 插：insert(int offset,xxx)
     * 长度：length(str)
     * 遍历：for + charAt() / toString()
     */
    @Test
    public void test1(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        //s1.delete(2,4);
        //s1.replace(2,4,"hello");
        //s1.insert(2,false);
        //s1.reverse();
        String s2 = s1.substring(1, 3);
        System.out.println(s2);
        System.out.println(s1);
    }
    /**
    * String,StringBuffer,StringBuilder:
     *  String:不可变，底层使用char []存储
     *  StringBuffer:可变，线程安全的，效率低，底层使用char []存储
     *  StringBuilder:可变，jdk1.5新增，线程不安全，效率高，底层使用char []存储
     *
     *  源码分析：
     *  String str = new String();//char value = new char[0];
     *  String str1 = new String("abc");//char value = new char[]{'a','b','c'};
     *
     *  StringBuffer sb1 = new StringBuffer();//char value = new char[16];底层创建了一个长度16的数组；
     *  sb1.append('a');//value[0] = 'a';
     *  sb1.append('b');//value[1] = 'b';
     *
     *  StringBuffer sb2 = new StringBuffer("abc");//char value = new char["abc".Length()+16];
     *
     *  //问题1：sb2.length();?
     *  //问题2：扩容：如果添加的超过16，那就需要扩容底层数组。默认扩容为原来的二倍+2，将原有数组复制到新的
     *          避免扩容。推荐使用：StringBuffer(int capacity)或StringBuilder(int capacity))
     *
     *
    * */
    @Test
    public void test(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
    }
}

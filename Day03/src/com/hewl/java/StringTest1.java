package com.hewl.java;

import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *
 * @author 何文亮
 * @date 2021-04-17
 *
 * 编码：字符串--->字节 (看得懂----看不懂)
 * 解码：字节---->字符串
 */
public class StringTest1 {

    @Test
    public void test2() throws UnsupportedEncodingException {
        //String --> byte[]:调用String的getBytes()
        String str = "abc123中国";
        //使用默认的字符集编码
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        //使用gbk字符集编码
        byte[] bytes1 = str.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));

        //byte [] --> String:调用String的构造器
        //使用默认的字符集解码
        String str2 = new String(bytes);
        System.out.println(str2);
        //乱码
        String str3 = new String(bytes1);
        System.out.println(str3);
        //正常
        String str4 = new String(bytes1,"gbk");
        System.out.println(str4);
    }
    @Test
    public void test1(){
        //String --> char[]:调用String的toCharArray()方法
        String str = "abc123";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }
        //char [] --> String:调用String的构造器
        char[] arr = new char[]{'h','e','l','l','o'};
        String s = new String(arr);
        System.out.println(s);
    }
    @Test
    public void test(){
        //String与其他结构(基本类型，包装类)的转换：
        //String --> 基本类型与包装类:调用包装类的静态方法：parseXxx(str)

        String str = "123";
        int a = Integer.parseInt(str);
        System.out.println(a);
        //基本类型与包装类 --> String:调用String重载的valueOf(xxx)方法
        String s1 = String.valueOf(a);
        String s2 = a + "";
        System.out.println(s1);
    }
}

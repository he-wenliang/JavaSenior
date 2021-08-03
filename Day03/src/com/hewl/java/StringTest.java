package com.hewl.java;

import org.junit.Test;

/**
 * @author 何文亮
 * @date 2021-03-21
 */
public class StringTest {

    /**
     * 1.常量与常量的拼接结果在常量池中，常量池中不会存在相同的常量；
     * 2.只要其中有一个常量，结果就在堆中；
     * 3.如果拼接的结果调用intern()方法，返回值就在常量池中。
     *
     */

    @Test
    public void test3(){
        String s1 = "Hello,";
        String s2 = "java";
        String s3 = "Hello,java";
        String s4 = "Hello," + "java";
        String s5 = s1 + "java";
        String s6 = "Hello," + s2;

        System.out.println(s3 == s4);
        //true
        System.out.println(s3 == s5);
        //false
        System.out.println(s3 == s6);
        //false
        System.out.println(s5 == s6);
        //false

        String s7 = s5.intern();
        //返回值得到的s7是常量池中已经存在的“Hello,java”
        System.out.println(s3 == s7);
        //true

    }
    /**
     * String的实例化方法：
     *  1.通过字面量定义的方法
     *  2.通过new + 构造器的方法
     *
     *    面试题：String s = new String("java");这种方式创建对象，在内存中创建了几个对象？
     *          答：2个；一个是堆空间中new结构；另一个是char[]对应的常量池中的数据。
     */
    @Test
    public void test2(){
        //此时的s1和s2声明在字符串常量池中
        String s1 = "java";
        String s2 = "java";
        //new + 构造器的方法的定义方法
        String s3 = new String("java");
        String s4 = new String("java");

        System.out.println(s1 == s2);
        //true
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);
        //false

        Person p1 = new Person("Andy",19);
        Person p2 = new Person("Andy",19);

        System.out.println(p1.name.equals(p2.name));
        //true
        System.out.println(p1.name == p2.name);
        //true

        p1.name = "Tom";
        System.out.println(p2.name);
        //Andy

    }

    /**
     * String :字符串，用双引号括起来
     * 1.String被声明为final，不可被继承
     * 2.String实现了Serializable接口：表示字符串是支持序列化的。
     *   实现了Comparable接口：表示字符串可以比较大小
     * 3.String内部定义了final char[] value用于存储字符串数组
     * 4.String：代表不可变的字符序列。简称:不可变性。
     *  体现：1.当对字符串重写赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值；
     *       2.当对现有的字符串进行链接操作时，也需要重新定义区域赋值；
     *       3.当调用String的replace（）方法修改时，也需要重新定义区域赋值；
     * 5.通过字面量的方式给字符串值赋值。此时的字符串常量值声明在字符串常量池中；
     * 6.字符串常量池中是不会存储相同内容的字符串；
     *
     */
    @Test
    public void test1(){
        //字面量的定义方式
        String s1 = "abc";
        String s2 = "abc";

        //比较它们的地址值
        System.out.println(s1==s2);

        s1 = "Hello";
        System.out.println(s1);
        System.out.println(s2);

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
    }
}

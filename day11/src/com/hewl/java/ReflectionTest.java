package com.hewl.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wen
 * @date 2021-07-16
 */
public class ReflectionTest {
    //反射之前的操作
    @Test
    public void test1(){
        //1.创建Person对象
        Person p1 = new Person("Andy",19);

        //2.通过对象调用内部属性和方法
        p1.setAge(16);
        System.out.println(p1.toString());

        p1.show();
        //在Person类外部，不可以通过对象去调用私有结构
        //比如：name,showNation,以及私有的构造器

    }
    //反射之后的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Andy", 16);
        Person p1 = (Person) obj;
        System.out.println(p1.toString());
        //通过反射，调用对象指定的属性与方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p1,15);
        System.out.println(p1.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p1);

        //通过反射，可以调用Person类的私有结构，私有构造器，私有方法，私有属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p = (Person)cons1.newInstance("Andy");
        System.out.println(p);
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Hans");
        System.out.println(p);
        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p,"中国");
        System.out.println(nation);

    }

    /*
    * 获取Class类的实例的方法
    *
    * */
    @Test
    public void test3() throws ClassNotFoundException {
        //1.调用运行时类的属性.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //2.通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        //3.调用Class的静态方法，forName(String classPath)
        Class clazz3 = Class.forName("com.hewl.java.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        //4.使用类的加载器
        ClassLoader loader = ReflectionTest.class.getClassLoader();
        Class clazz4 = loader.loadClass("com.hewl.java.Person");
        System.out.println(clazz4);
    }
}

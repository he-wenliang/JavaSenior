package com.hewl.java;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射，创建运行时类的对象
 *
 * @author wen
 * @date 2021-07-17
 */
public class NewInstanceTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        Person obj = clazz.newInstance();

        System.out.println(obj);
    }

    //反射的动态性
    @Test
    public void test1() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0.1.2
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.hewl.java.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //创建一个指定类的对象
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}

package com.hewl.java2;

import com.hewl.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author wen
 * @date 2021-07-18
 */
public class FieldTest {
    @Test
    public void test(){
        Class clazz = Person.class;
        //获取属性结构
        //getFields():获取运行时类及其父类声明为public的属性
        Field[] fields = clazz.getFields();
        for(Field f: fields){
            System.out.println(f);
        }

        System.out.println();

        //getDeclaredFields():获取当前运行时类的所有属性(不包括父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f: declaredFields){
            System.out.println(f);
        }

    }
    //修饰符 类型 变量名
    @Test
    public void test1(){
        Class clazz = Person.class;

        Field[] fields = clazz.getDeclaredFields();
        for(Field f:fields){
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");
            //3.变量名
            String name = f.getName();
            System.out.print(name);

            System.out.println();
        }
    }
}

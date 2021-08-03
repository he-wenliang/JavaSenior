package com.hewl.java;

import java.util.ArrayList;

/**
 *
 * @author 何文亮
 * @date 2021-05-09
 */

public class AnnotationTest {
    public static void main(String[] args) {
        Person s = new Student();
        s.walk();
    }
}
//1)可重复注解：在需要重复的注解上声明@Repeatable,成员值为MyAnnotation.class
//2)MyAnnotation的Target和Retention等元注解和MyAnnotations相同

//1)类型注解：
            //TYPE_PARAMETER:写到类型变量的声明语句中（如泛型声明）
            //TYPE_USE:表示该注解可以写到任何类型的任何语句中

@MyAnnotation(value = "hi")
@MyAnnotation(value = "Hello")
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void walk(){
        System.out.println("人走路！");
    }

    public void eat(){
        System.out.println("人吃饭！");
    }
}
interface Info1{
    void show();
}
class Student extends Person implements Info1{
    @Override
    public void walk() {
        System.out.println("学生走路！");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T >{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}
package com.hewl.java2;

import com.hewl.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取运行时类的方法结构
 *
 * @author wen
 * @date 2021-07-18
 */
public class MethodTest {
    @Test
    public void test(){
        Class clazz = Person.class;

        //getMethods():获取当前运行时类及其所有父类中声明为public的方法
        Method[] methods = clazz.getMethods();
        for(Method m: methods){
            System.out.println(m);
        }

        System.out.println();
        //getDeclaredMethods():获取当前运行时类中所有声明过的方法
        Method[] declaredMethod = clazz.getDeclaredMethods();
        for(Method m: declaredMethod){
            System.out.println(m);
        }
    }
    //@Xxxxx
    //权限修饰符 返回值类型 方法名 (参数类型1 形参名1,...) throws XxxException{}
    @Test
    public void test1(){
        Class clazz = Person.class;

        Method[] declaredMethod = clazz.getDeclaredMethods();
        for(Method m: declaredMethod){

            //1.获取方法声明的注解
            Annotation[] annos = m.getAnnotations();
            for(Annotation a:annos){
                System.out.println(a);
            }

            //2.权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //3.返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //4.方法名
            System.out.print(m.getName());

            //5.形参列表
            System.out.print("(");
            Class[] parameterTypes = m.getParameterTypes();
            if(!(parameterTypes == null || parameterTypes.length == 0)){
                for (int i = 0; i < parameterTypes.length; i++) {

                    if(i == parameterTypes.length-1){
                        System.out.print(parameterTypes[i].getName() + " arg_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " arg_" + i + ",");
                }
            }
            System.out.print(")");

            //6.抛出的异常
            Class[] exceptionTypes = m.getExceptionTypes();
            if(exceptionTypes.length > 0){
                System.out.print(" throw ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }
}

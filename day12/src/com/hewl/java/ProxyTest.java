package com.hewl.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理：
 *
 * @author wen
 * @date 2021-07-19
 */

interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("===================通用方法1===================");
    }
    public void method2(){
        System.out.println("===================通用方法2===================");
    }
}
/*
实现动态代理，需要解决的问题？
    1.如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象？
    2.当通过代理类的对象去调用方法时，如何动态的去调用被代理类中的同名方法？
*/

class ProxyFactory{
    //调用此方法，返回一个代理类对象
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们通过代理类的对象调用方法a时，就会自动的调用如下的方法
    //将被代理类要执行的方法a就声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method():即为代理类对象调用的方法，此方法也就作为被代理类的调用
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj,args);

        util.method2();
        //上述方法的返回值就作为当前类中的invoke()方法的返回值
        return returnValue;

    }
}

public class ProxyTest {
    public static void main(String[] args) {

        SuperMan sp = new SuperMan();

        //proxyFactory:代理类的对象
        Human proxyFactory = (Human) ProxyFactory.getProxyInstance(sp);
        //当通过代理类调用方法时，会自动去调用被代理类的同名方法
        String str = proxyFactory.getBelief();
        //System.out.println(str);
        proxyFactory.eat("拉面");

        //System.out.println("******************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothInstance = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothInstance.produceCloth();

    }
}

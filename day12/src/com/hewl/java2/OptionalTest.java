package com.hewl.java2;

import org.junit.Test;

import java.util.Optional;

/**
 * @author wen
 * @date 2021/7/28 - 16:47
 */
public class OptionalTest {
    
    @Test
    public void test(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalgirl1 = Optional.of(girl);

    }

    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalgirl1 = Optional.ofNullable(girl);
        System.out.println(optionalgirl1);

        Girl girl1 = optionalgirl1.orElse(new Girl("Andy"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test2(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的方法getGirlName()
    public String getGirlName1(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return girl.getName();
            }
        }
        return null;
    }
    @Test
    public void test3(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGrilName()
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        //boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("刘亦菲")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        //girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("杨超越"));

        return girl1.getName();
    }

    @Test
    public void  test4(){
        Boy boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("果果"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}

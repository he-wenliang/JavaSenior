package com.hewl.exer;

/**
 * @author 何文亮
 * @date 2021-04-11
 */
public class StringTest {
    //面试题

    String str = new String("good");
    char ch[] = {'t','e','s','t'};
    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str,ex.ch);
        System.out.println(ex.str + " and ");
        System.out.println(ex.ch);
    }
}
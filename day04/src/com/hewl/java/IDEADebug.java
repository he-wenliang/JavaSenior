package com.hewl.java;

import org.junit.Test;

/**
 * @author 何文亮
 * @date 2021-05-08
 */
public class IDEADebug {
    @Test
    public void test(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//"null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
        System.out.println(sb1);//
    }
}

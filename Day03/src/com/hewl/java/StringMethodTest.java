package com.hewl.java;

import org.junit.Test;

/**
 * @author 何文亮
 * @date 2021-04-12
 */
public class StringMethodTest {
    @Test
    public void test4(){
        //替换
        String str = "我说今晚月光那么美！我";
        String str1 = str.replace('我','你');
        System.out.println(str1);

        String str2 = str.replace("月光","果果");
        System.out.println(str2);
        //匹配
        String str3 = "123Hello456World789Java123";
        String str4 = str3.replaceAll("\\d+",",").replaceAll("^,|,$","");
        System.out.println(str4);

        String str5 = "123456";
        boolean matches = str5.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
        //切片
        String sourceStr="1,2,3,4,5";
        String[] sourceStrArray=sourceStr.split(",");
        for(int i=0;i<sourceStrArray.length;i++)
        {
            System.out.println(sourceStrArray[i]);
        }

        String s1 = "hello|world|java";
        String[] strs = s1.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String s2 = "hello.world.java";
        //System.out.println(s2.length());
        String[] strs1 = s2.split("\\.");
        for (int i = 0; i < strs1.length; i++) {
            System.out.println(strs1[i]);
        }
    }
    @Test
    public void test3() {
        String str1 = "HelloWorld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = str1.startsWith("he");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);

        String str2 = "wo";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lo"));
        System.out.println(str1.indexOf("lo", 5));

        String str3 = "helloworld";
        System.out.println(str1.lastIndexOf("or"));
        System.out.println(str1.lastIndexOf("or",6));
    }

    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = s1.toLowerCase();
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        //涉及到字符串排序
        System.out.println(s5.compareTo(s6));

        String s7 = "你就是我最想要的丫头！";
        System.out.println(s7.substring(3));
        //[8,10)
        System.out.println(s7.substring(8, 10));
    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(1));
        //s1 = "";
        System.out.println(s1.isEmpty());
        String s2 = s1.toLowerCase();
        System.out.println(s1);
        //s1不可变
        System.out.println(s2);
        System.out.println(s1.toUpperCase());
        String s3 = " He llo World ";
        String s4 = s3.trim();
        System.out.println("***********" + s3 + "***********");
        System.out.println("***********" + s4 + "***********");
    }
}

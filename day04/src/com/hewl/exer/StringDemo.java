package com.hewl.exer;

import org.junit.Test;

/**
 * @author 何文亮
 * @date 2021-05-06
 */
public class StringDemo {

    /*
     * 部分字符串反转
     * 1.转换为char []
     */

    public String reverse(String str,int startIndex,int endIndex){
        if(str != null){
            char[] arr = str.toCharArray();
            for (int i = startIndex,j = endIndex; i < j;i++,j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        }else{
            return null;
        }
    }

    /*
     * 方式二：使用String的拼接操作
     */

    public String reverse1(String str, int startIndex, int endIndex){
        if(str != null){
            //1
            String reverseStr = str.substring(0,startIndex);
            //2
            for (int i = endIndex; i >= startIndex ; i--) {
                reverseStr += str.charAt(i);
            }
            //3
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }

    /*
     * 方式三：使用StringBuffer/StrinBuilder替换String
     */

    public String reverse2(String str, int startIndex, int endIndex){
        if(str != null){
            StringBuilder builder = new StringBuilder(str.length());
            //1
            builder.append(str.substring(0,startIndex));
            //2
            for (int i = endIndex; i >= startIndex ; i--) {
                builder.append(str.charAt(i));
            }
            //3
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void testReverse(){
//        String str = "abcdefg";
//        String reverse = reverse1(str, 2, 5);
//        System.out.println(reverse);
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}

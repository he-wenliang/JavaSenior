package com.hewl.exer;

import org.junit.Test;

/**
 * @author 何文亮
 * @date 2021-05-08
 */
public class StringDemo2 {
    /*
    *   获取最大的相同字串
    *
    */
//前提：只有一个最大字串
    public String getMaxStr(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0,y = length - i; y <= length; x++,y++) {
                    String subStr = minStr.substring(x, y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void test(){
        String str1 = "jkfhhellojkdfhnvjhf";
        String str2 = "hjhello";
        String str3 = getMaxStr(str1,str2);
        System.out.println(str3);
    }
}

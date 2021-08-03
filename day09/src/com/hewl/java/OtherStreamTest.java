package com.hewl.java;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 1.标准的输入输出流：System.in  System.out
 * 2.打印流
 * 3.数据流
 *
 * @author wen
 * @date 2021-07-14
 */
public class OtherStreamTest {
    //读入字符串，转为大写输出，知道e或exit
    //方式一：Scanner:调用next()返回一个字符串
    //方式二：System.in----转换流----BufferReader的readLine()
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            System.out.println("请输入字符串：");
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test(){

    }
}

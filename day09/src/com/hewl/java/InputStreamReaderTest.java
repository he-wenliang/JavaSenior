package com.hewl.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流二：转换流--->字符流
 *  InputStreamReader：字节的输入流---字符的输入流
 *  OutputStreamWriter：字符的输出流---字节的输出流
 *
 * @author wen
 * @date 2021-07-14
 */
public class InputStreamReaderTest {
    @Test
    public void test1(){
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
//        InputStreamReader isr = new InputStreamReader(fis);
            isr = new InputStreamReader(fis,"UTF-8");

            char[] cubf = new char[20];
            int len;
            while((len = isr.read(cubf)) != -1){
                String str = new String(cubf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){}
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test2(){
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            File file1 = new File("hello.txt");
            File file2 = new File("hello_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            //读写过程
            char[] cubf = new char[20];
            int len;
            while((len = isr.read(cubf)) != -1){
                osw.write(cubf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null){

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw != null){

                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

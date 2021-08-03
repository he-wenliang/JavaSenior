package com.hewl.java;

import org.junit.Test;

import java.io.*;

/**
 * @author wen
 * @date 2021-06-28
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //实例化File类的对象，指明要操作的对象
            File file = new File("hello.txt");//相较于当前model
            //提供具体的流
            fr = new FileReader(file);
            //数据的读入：read()返回读入的一个字符，如果达到文件末尾，返回-1
            //方式一:
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }
            //方式二：
            int data;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流的关闭操作
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //对read():升级，使用read的重载方法
    @Test
    public void trstFileReader1() {
        //1.File类的实例化
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                //方式一：
                //错误
//                for (int i = 0; i < cbuf.length; i++) {
                //正确
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                //错误
//                String str = new String(cbuf);
//                System.out.print(str);
                //正确
                String str1 = new String(cbuf,0,len);
                System.out.print(str1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //从内存中将数据写出到硬盘中
    @Test
    public void testWriterTest() {
        FileWriter fw = null;
        try {
            //1.提供File对象，提供写出到的文件
            File file = new File("hello1.txt");
            //2.提供File Writer对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的操作
            fw.write("I huve a dream!");
            fw.write("You too!");
            //4.六资源的关闭
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderFileWriter() {
        //实现文本的复制操作
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //若是图片得使用字节流
            //2.创建输入和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf中的字符个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

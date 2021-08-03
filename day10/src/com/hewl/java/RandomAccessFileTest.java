package com.hewl.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author wen
 * @date 2021-07-15
 */
public class RandomAccessFileTest {
    @Test
    public void test() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("超越.jpg", "r");
            raf2 = new RandomAccessFile("超越1.jpg", "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null)
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    @Test
    public void test1() throws IOException {
        RandomAccessFile raf1  = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.close();
    }
    /*
    * 使用RandomAccessFile实现数据的插入操作
    * */
    @Test
    public void test2() throws IOException{
        RandomAccessFile raf1  = new RandomAccessFile("hello.txt", "rw");

        raf1.seek(3);
        //保存指针3之后的数据到StringBuilder中
        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针
        raf1.seek(3);
        raf1.write("xyz".getBytes());
        //将StringBuilder中的写入
        raf1.write(builder.toString().getBytes());
        //关闭
        raf1.close();
    }
}

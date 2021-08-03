package com.hewl.exer;

import org.junit.Test;

import java.io.*;

/**
 * @author wen
 * @date 2021-07-14
 */
public class MyInput {
    public static String readString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = "";

        try {
            string = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return string;
    }
    public static int readInt(){
        return Integer.parseInt(readString());
    }
    public static double readDouble(){
        return Double.parseDouble(readString());
    }
    public static double readByte(){
        return Byte.parseByte(readString());
    }
    public static double readShort(){
        return Short.parseShort(readString());
    }
    public static double readLong(){
        return Long.parseLong(readString());
    }
    public static double readFloat(){
        return Float.parseFloat(readString());
    }

    @Test
    public void test(){
        for (int i = 0; i <= 255; i++) {
            System.out.print((char)i);
            if(i % 50 == 0){
                System.out.println();
            }
        }
    }
    @Test
    public void test1() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("果果");
        dos.flush();
        dos.writeInt(18);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();
        dos.close();
    }
    @Test
    public void test2() throws IOException {
        //读取的舒徐和写入的顺序必须一致
        //1.
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        //2.
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();
        System.out.println("姓名：" + name + " 年龄：" + age + " 性别：" + isMale);
        //3.
        dis.close();
    }
}

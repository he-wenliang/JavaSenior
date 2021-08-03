package com.hewl.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：它的强大之处可以将Java对象写入数据源中，也能把Java对象从数据源中还原回去;
 *
 * @author wen
 * @date 2021-07-14
 */
public class ObjectInputOutputStreamTest {
    /*
     * 序列化：将内存中的Java对象保存到磁盘中或通过网络传出去
     * 使用ObjectOutputStream实现
     *
     */

    @Test
    public void ObjectOutputStream_test(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京！！"));
            oos.flush();

            oos.writeObject(new Person("许巍",52));
            oos.flush();

            oos.writeObject(new Person("GG",52,new Account(500)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    * 反序列化：将磁盘文件中的对象还原为内存中的Java对象
    * 使用ObjectInputStream实现
    *
    * */
    @Test
    public void ObjectInputStream_Test(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String)obj;
            System.out.println(str);

            Person p = (Person)ois.readObject();
            Person p1 = (Person)ois.readObject();

            System.out.println(p);
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

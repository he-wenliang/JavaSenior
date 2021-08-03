package com.hewl.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author wen
 * @date 2021-06-06
 */
public class PropertiesTest {
    public static void main(String[] args) {
        FileInputStream fis =null;
        try {
            Properties prop = new Properties();
            fis = new FileInputStream("jdbc.properties");
            prop.load(fis);//加载流对应的文件

            String name = prop.getProperty("name");
            String password = prop.getProperty("password");

            System.out.println("name = " + name + ",password = " + password);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

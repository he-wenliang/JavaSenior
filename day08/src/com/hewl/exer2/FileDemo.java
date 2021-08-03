package com.hewl.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author wen
 * @date 2021-06-10
 */
public class FileDemo {
    @Test
    public void FindJpg(){
        File srcFile = new File("E:\\大三（上）\\寒假\\Java\\io");
        String[] fileNames = srcFile.list();
        for(String fileName : fileNames){
            if(fileName.endsWith(".jpg")){
                System.out.println(fileName);
            }
        }
    }
    @Test
    public void test() throws IOException {
        File file = new File("E:\\大三（上）\\寒假\\Java\\io\\io1\\hello.txt");
        //创建一个与file同目录下的另外一个文件，文件名为：haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }
    }
}

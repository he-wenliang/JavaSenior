package com.hewl.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author wen
 * @date 2021-06-09
 */
public class FileTest {
    @Test
    public void test6(){
        //文件目录的创建
        File file = new File("E:\\大三（上）\\寒假\\Java\\io\\io1\\io3");
        boolean mkdir = file.mkdir();
        if(mkdir){
            System.out.println("Successful111！");
        }

        File file1 = new File("E:\\大三（上）\\寒假\\Java\\io\\io1\\io4");
        boolean mkdir1 = file1.mkdirs();
        if(mkdir1){
            System.out.println("Successful222！");
        }
        //要想删除成功，io4下不能有子目录或文件
        File file2 = new File("E:\\大三（上）\\寒假\\Java\\io\\io1\\io4");
        System.out.println(file2.delete());
    }
    @Test
    public void test5() throws IOException {
        File file = new File("hi.txt");
        if(!file.exists()){
            //文件的创建
            file.createNewFile();
            System.out.println("Successful!");
        }else{//文件存在
            file.delete();
            System.out.println("Delete!");
        }
    }

    @Test
    public void test4(){
        File file1 = new File("hello.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("E:\\大三（上）\\寒假\\Java\\io");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }
    //把文件重命名为指定的文件路径：file1.renameTo(file2)
    //需要file1存在，且file2不存在
    @Test
    public void test3(){
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\大三（上）\\寒假\\Java\\io\\hi.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }
    @Test
    public void test2(){
        File file1 = new File("E:\\大三（上）\\寒假\\Java\\JavaSenior");

        String[] list = file1.list();
        for(String s:list){
            System.out.println(s);
        }
        File[] files = file1.listFiles();
        for(File f:files){
            System.out.println(f);
        }
    }
    //File的基本方法1
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\大三（上）\\寒假\\Java\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    //相对路径：相较于某个路径下
    //绝对路径：包含盘符在内的文件目录的路径
    @Test
    public void test(){
        //相对于当前modual
        //构造器一:
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\大三（上）\\寒假\\Java\\JavaSenior\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);
        //构造器二:
        File file3 = new File("E:\\大三（上）\\寒假\\Java","JavaSenior");
        System.out.println(file3);
        //构造器三:
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }
}

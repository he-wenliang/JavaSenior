package com.hewl.java1;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wen
 * @date 2021-07-15
 */
public class URLTest {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629&spm_id_from=pageDriver");

//           public String getProtocol()获取该URL的协议名
            System.out.println(url.getProtocol());
//           public String getHost()获取该URL的主机名
            System.out.println(url.getHost());
//           public String getPort()获取该URL的端囗号
            System.out.println(url.getPort());
//           public String getPath()获取该URL的文件路径
            System.out.println(url.getPath());
//           public String getFile()获取该URL的文件名
            System.out.println(url.getFile());
//           public String getQuety()获取该URL的查询名
            System.out.println(url.getQuery());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {

    }
}

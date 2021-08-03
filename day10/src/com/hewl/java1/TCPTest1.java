package com.hewl.java1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 例子1：客户端发送信息，服务器显示在控制台上
 *
 * @author wen
 * @date 2021-07-15
 */
public class TCPTest1 {
    //客户端
    @Test
    public void client() {
        Socket sk = null;
        OutputStream ops = null;
        try {
            //1.创建Socket对象,指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            sk = new Socket(inet,8899);
            //2.获取输出流，用于获取数据
            ops = sk.getOutputStream();
            //3.写出数据的操作
            ops.write("您好，我是------------".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if(ops != null){
                try {
                    ops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sk != null){
                try {
                    sk.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //服务器端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket acc = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建服务器的ServerSocket对象，指明自己的端口号
            ss = new ServerSocket(8899);
            //2.调用accept()用与接收客户端的Socket
            acc = ss.accept();
            //3.获取输入流
            is = acc.getInputStream();
            //不建议这样写,可能有乱码
//        byte[] buffer = new byte[1024];
//        int len;
//        while((len = is.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.println(str);
//        }
            //建议这样写
            //4.读取输入流的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos.toString());
            System.out.println("收到来自："+ acc.getInetAddress().getHostAddress()+ "的信息！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            if(baos != null){

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(acc != null){

                try {
                    acc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

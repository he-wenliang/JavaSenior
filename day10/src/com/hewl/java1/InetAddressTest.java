package com.hewl.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wen
 * @date 2021-07-15
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet = InetAddress.getByName("192.168.13.14");

            InetAddress inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getLocalHost();
            System.out.println(inet2);


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

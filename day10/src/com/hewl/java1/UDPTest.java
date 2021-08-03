package com.hewl.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author wen
 * @date 2021-07-15
 */
public class UDPTest {
    @Test
    public void send() throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String str = "你就是我最UDP";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket dp = new DatagramPacket(data,0,data.length,inet,9090);

        ds.send(dp);
        ds.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket dp = new DatagramPacket(buffer, 0,buffer.length);

        socket.receive(dp);
        System.out.println(new String(dp.getData(),0,dp.getLength()));
        socket.close();
    }
}

package com.alfaday.tools.demo.io.bio;


import com.alfaday.tools.demo.io.nio.Constant;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;


public class Client{

    public static void main(String[] args) {


        byte[] bytes = new byte[1024];
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(true);
            //请求连接
            channel.connect(new InetSocketAddress("localhost", Constant.port));
            channel.socket().getOutputStream().write("client-1".getBytes("utf-8"));
            System.out.println("write ok");
            channel.socket().getInputStream().read(bytes);
            String s = new String(bytes, "utf-8");
            System.out.println("read ok:" +s);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

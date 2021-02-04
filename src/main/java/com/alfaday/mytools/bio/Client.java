package com.alfaday.mytools.bio;


import com.alfaday.mytools.nio.Constant;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;


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

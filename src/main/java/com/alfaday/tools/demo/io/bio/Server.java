package com.alfaday.tools.demo.io.bio;


import com.alfaday.tools.demo.io.nio.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class Server {

    private ServerSocketChannel servSocketChannel;
    private byte[] buffer = new byte[1024];

    public static void main(String[] args){
        Server xiaona = new Server();
        xiaona.init();
        xiaona.listen();
    }

    private void init(){

        try {
            this.servSocketChannel = ServerSocketChannel.open();
            this.servSocketChannel.configureBlocking(false);
            //绑定端口
            this.servSocketChannel.socket().bind(new InetSocketAddress(Constant.port));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server init sus");
    }

    private void listen() {
        while (true) {
            try {
                SocketChannel accept = servSocketChannel.accept();
                if (accept == null) {
                    Thread.sleep(100);
                    continue;
                }
                System.out.println("accept ok:" + new Date());
                Socket socket = accept.socket();

                InputStream inputStream = socket.getInputStream();
                int read = inputStream.read(buffer);
                System.out.println("read from cilent =" + new String(buffer,"utf-8"));
                socket.getOutputStream().write("im server-1".getBytes("utf-8"));
                System.out.println("write ok");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

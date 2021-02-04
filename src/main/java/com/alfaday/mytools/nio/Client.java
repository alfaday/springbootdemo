package com.alfaday.mytools.nio;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


public class Client implements Runnable{
    private BlockingQueue<String> words;
    private Random random;

    public static void main(String[] args) {
        //种多个线程发起Socket客户端连接请求
        for(int i=0; i<1; i++){
            Client c = new Client();
            c.init();
            new Thread(c).start();
        }
    }

    @Override
    public void run() {
        SocketChannel channel = null;
        Selector selector = null;
        try {
            channel = SocketChannel.open();
            channel.configureBlocking(false);
            //请求连接
            channel.connect(new InetSocketAddress("localhost", Constant.port));
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_CONNECT);
            boolean isOver = false;

            while(! isOver){
                selector.select();
                Iterator ite = selector.selectedKeys().iterator();
                while(ite.hasNext()){
                    SelectionKey key = (SelectionKey) ite.next();
                    ite.remove();

                    if(key.isConnectable()){
                        System.out.println("isConnectable = true:" + new Date());
                        if(channel.isConnectionPending()){
                            if(channel.finishConnect()){
                                System.out.println("Connect sus:" +new Date());
                                //只有当连接成功后才能注册OP_READ事件
                                key.interestOps(SelectionKey.OP_READ);
                                //模拟业务处理耗时
                                sleep();
                                channel.write(CharsetHelper.encode(CharBuffer.wrap(getWord())));
                            }
                            else{
                                key.cancel();
                            }
                        }
                    }
                    else if(key.isReadable()){
                        System.out.println("read sus:" +new Date());
                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                        channel.read(byteBuffer);
                        byteBuffer.flip();
                        CharBuffer charBuffer = CharsetHelper.decode(byteBuffer);
                        String answer = charBuffer.toString();
                        System.out.println(Thread.currentThread().getId() + "--- answer:" + answer);

                        String word = getWord();
                        if(word != null){
                            channel.write(CharsetHelper.encode(CharBuffer.wrap(word)));
                        }
                        else{
                            isOver = true;
                        }
                        //模拟业务处理耗时
                        sleep();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(channel != null){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(selector != null){
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void init() {
        words = new ArrayBlockingQueue<String>(5);
        try {
            words.put("hi");
            words.put("who");
            words.put("what");
            words.put("where");
            words.put("bye");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        random = new Random();
    }

    private String getWord(){
        return words.poll();
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

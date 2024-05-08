package com.itheima.backend.test;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        try{
            server = new ServerSocket(1024);
            System.out.println("Server started");
            Socket socket = server.accept();
            String ip = socket.getInetAddress().getHostAddress();
            System.out.println("有客户链接ip: " + ip + "端口: " + socket.getPort());

            new Thread( () -> {
                while(true){
                    try {
                        InputStream inputStream = socket.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String readData = bufferedReader.readLine();
                        System.out.println("收到客户端消息-->" + readData);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();



        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

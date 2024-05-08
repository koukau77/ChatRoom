package com.itheima.backend.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket("127.0.0.1", 1024);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            System.out.println("Connected to server, please input something");
            new Thread( () -> {
                while(true){
                    try {
                        Scanner scanner = new Scanner(System.in);
                        String input = scanner.nextLine();

                        printWriter.println(input);
                        printWriter.flush();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();



        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

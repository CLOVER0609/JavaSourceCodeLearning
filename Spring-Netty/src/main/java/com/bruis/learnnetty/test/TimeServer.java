package com.bruis.learnnetty.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TODO 类描述
 *
 * @author weiyu
 * @version v1.0
 * @date 2021-07-27 22:15
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port =8080;
        if(args != null && args.length >0){
            try {
                port =Integer.valueOf(args[0]);

            }catch ( NumberFormatException e){
                // 采用默认值

            }

        }

        ServerSocket server =null;
        try {
            server =new ServerSocket(port);
            System.out.println("the time server is start in port "+port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler()).start();
            }
        }catch (Exception e){

        }
    }
}

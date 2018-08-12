package com.example.siva1.handy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by siva1 on 26/10/2016.
 */
public class SingleTon {
    static public Socket socket;
    static PrintWriter printWriter;
    private static  SingleTon instance;
    private SingleTon(){

    }
    public static SingleTon getInstance(String ip,int port) throws IOException {
        if(instance==null){
            instance=new SingleTon();
            socket=new Socket(ip,port);
            printWriter=new PrintWriter(socket.getOutputStream(),true);
        }
        return instance;
    }
    public static SingleTon getInstance(){
        return instance;
    }
    public void sendData(String data){
        printWriter.println(data);
        printWriter.flush();
    }
}

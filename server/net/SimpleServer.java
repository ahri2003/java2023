package server.net;

import server.parser.Parser;
import server.thread.StudentServer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public void run(){
        ServerSocket server =null;
        Socket socketS =null;
        InetAddress iaddress = null;
        int port = 4330;
        try{
            server = new ServerSocket(port);
            System.out.println("Server started,waiting for request...");
        }catch(IOException e){
            e.printStackTrace();
        }
        while (true) {
            try {
                socketS = server.accept();
                Runnable stuServer = new StudentServer(socketS);
                Thread thd = new Thread(stuServer);
                thd.start();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

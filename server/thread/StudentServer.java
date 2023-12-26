package server.thread;

import server.parser.Parser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;


public class StudentServer implements Runnable{
    Socket socket = null;
    public StudentServer(Socket socket){
        this.socket= socket;
    }
    private void service(){
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String requestStr = in.readUTF();
            System.out.println("server get message:" + requestStr);


            String responseStr = getResponseStr(requestStr);    //"A01-87"
            out.writeUTF(responseStr);
            //System.out.println("server response:"+responseStr);

            in.close();
            out.close();
            socket.close();
        } catch(IOException e){
                e.printStackTrace();
            }
    }

    private String getResponseStr(String requestStr){
        Parser par = new Parser();
        return par.run(requestStr);
    }
    public void run(){
        service();
    }
}

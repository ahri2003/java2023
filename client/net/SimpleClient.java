package client.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SimpleClient {
    private String ip= "None";
    private int port=4330;
    private String requestStr = "";

    public SimpleClient(String ip,int port,String requestStr){
        this.ip=ip;
        this.port=port;
        this.requestStr=requestStr;
    }
    public String run(){
        Socket socketC = null;
        DataOutputStream out=null;
        DataInputStream in=null;

        String responseStr="None";

        try {
            socketC = new Socket(ip, port);
            System.out.println("connecting ok!");
        }catch(Exception e){
            e.printStackTrace();
        }

        try {
            out = new DataOutputStream(socketC.getOutputStream());
            in = new DataInputStream(socketC.getInputStream());

            //requestStr = "zhangsan";
            out.writeUTF(requestStr);
            //System.out.println("send message:"+requestStr);

            responseStr = in.readUTF();
            System.out.println("receive message:"+responseStr);

            in.close();
            out.close();
            socketC.close();
            System.out.println("Disconnected!");
        }catch (Exception e){
            e.printStackTrace();
        }

        return responseStr;
    }
}

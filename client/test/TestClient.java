package client.test;
import java.util.Scanner;
import client.view.CmdView;
import client.gui.GuiFrame;

import java.awt.event.ActionEvent;

public class TestClient {
    public static void main(String [] args){
        String para = "None";

        //非开发环境
        //if(args.length==1){
        //    para = args[0].trim();
        //}

        Scanner sc = new Scanner(System.in);
        System.out.println("cmd or gui");
        para = sc.next();

        run(para);
    }

    public static void run(String para){

        if("cmd".equals((para))){
            CmdView cd = new CmdView();
            cd.run();
        } else if ("gui".equals(para)) {
            GuiFrame gf= new GuiFrame("学生成绩查询项目");
            gf.run();
        }else {
            System.out.println("Command format error!");
            System.out.println("usage:java TestClient cmd");
            System.out.println("or:java TestClient gui");
            System.out.println("Try again!");
        }


    }

}

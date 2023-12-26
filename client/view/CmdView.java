package client.view;

import java.util.Scanner;
import client.net.SimpleClient;
public class CmdView {
    public void run(){
        boolean flag = true;
        while (flag) {
            display();
            int n = input();
            flag = process(n);
        }
    }

    private void display(){
        System.out.println("\n\t查询菜单：");
        System.out.println("1.Get Student Grade");
        System.out.println("2.Student Manage");
        System.out.println("3.Add Student Manage");
        System.out.println("0.Exit");
    }
    private int input(){
        System.out.print("please:");
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
    }
    private boolean process(int n){
        boolean flag = true;
        if (n==1) {
            String grade = getGrade();
            System.out.println("grade="+grade);
        }
        else if (n==2){

        }
        else if (n==3) {

        }
        else if (n==0) {
            flag = false;
        }
        else{
            System.out.println("The choice:0-2,please input:");
        }
        return flag;
    }

    private String getGrade(){
        String code = "A01";
        String commandStr = getCommandCode(code);

        //send command String;
        SimpleClient sc=new SimpleClient("10.12.17.8",4330,commandStr);

        String responsStr = sc.run();

        String result = getStudentGrade(responsStr);
        return result;
    }

    private String getCommandCode(String code){
        System.out.print("Input student code:");
        Scanner sc=new Scanner(System.in);
        String sid = sc.nextLine();
        String result = code +"-"+sid;
        return result;
    }

    private String getStudentGrade(String cmdStr){
        String gradeStr = "None";
        String [] result=cmdStr.split("-");
        if(result.length!=2){
            gradeStr = "None";
        }
        else {
            if ("A01".equals(result[0])) {
                gradeStr = result[1].trim();
            }
        }
        return gradeStr;
    }
}

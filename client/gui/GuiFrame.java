package client.gui;


import client.net.SimpleClient;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiFrame implements ActionListener {
    private JFrame mainFrame;
    private JLabel lb;
    private JButton jb;
    private JTextField jf;
    public GuiFrame(String title){
        mainFrame = new JFrame(title);
    }

    public void run(){
        mainFrame.setBounds(100,100,400,300);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());

        lb = new JLabel("查询学生成绩结果");
        lb.setFont(new Font("宋体",Font.PLAIN,30));
        lb.setForeground(Color.black);
        lb.setHorizontalAlignment(SwingConstants.CENTER);

        jb = new JButton("确定");
        jb.addActionListener(this);

        jf = new JTextField(20);

        mainFrame.add(jf);
        mainFrame.add(jb);
        mainFrame.add(lb);

        mainFrame.validate();
    }
    public void actionPerformed(ActionEvent e){
        String inputText = e.getActionCommand();
        if(inputText.equals("确定")){
            String code = "A01-";
            String commandStr = jf.getText().trim();
            commandStr = code +commandStr;

            //send command String;
            SimpleClient sc=new SimpleClient("127.0.0.1",4330,commandStr);

            String responsStr = sc.run();

            String result = getStudentGrade(responsStr);
            lb.setText("学生成绩="+result);
        }
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

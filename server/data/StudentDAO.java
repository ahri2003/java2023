package server.data;

//import server.data.DataAble;
import server.data.file.FileOperation;

public class StudentDAO {
    private DataAble fp;
    public StudentDAO(){
        fp = new FileOperation("E:\\Java调试测试\\grade management system\\src\\server\\data\\file\\student.txt");
    }
    public String getGrade(String code){
        return  fp.getGrade(code);
    }
}

package cn.edu.uestc.aone.web.helloworld.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
@WebServlet("/HelloForm")
public class HelloForm extends  HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String path = "D:/";
    private static String filenameTemp;
    public static boolean creatTxtFile(String name) throws IOException {
        boolean flag = false;
        filenameTemp = path + name + ".txt";
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
            flag = true;
        }
        return flag;
    }
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    public HelloForm() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
        String filename=getRandomString(10);
        creatTxtFile(filename);
        File F=new File(filenameTemp);
        FileWriter fileWritter = new FileWriter(F,true);
        fileWritter.write(name);
        fileWritter.close();
        FileReader fr = new FileReader("D:/test.txt");
        char[] a = new char[50];
        fr.read(a); // 读取数组中的内容
        for (char c : a)
            out.print(c); // 一个一个打印字符
        fr.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

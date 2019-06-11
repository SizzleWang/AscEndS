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
    private static String path = "D:/temp/input/";
    private static String filenameTemp;
    public static String creatTxtFile1(String name) throws IOException {
        filenameTemp = "D:/temp/" + name + ".txt";
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
        }
        return filenameTemp;
    }
    public static String creatTxtFile2(String name) throws IOException {
        filenameTemp = path + name + ".txt";
        File filename = new File(filenameTemp);
        if (!filename.exists()) {
            filename.createNewFile();
        }
        return filenameTemp;
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
        String x=creatTxtFile1(filename);
        String y=creatTxtFile2(filename);
        File F=new File(y);
        FileWriter fileWritter = new FileWriter(F,true);
        fileWritter.write(name);
        fileWritter.close();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileReader fr = new FileReader(x);
        char[] a = new char[500000];
        fr.read(a); // 读取数组中的内容
        for (char c : a)
            out.print(c); // 一个一个打印字符
        fr.close();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

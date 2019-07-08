package cn.lyx.web.Servlet;

import cn.lyx.web.Servlet.JDBC.LogIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/test2")
public class Test02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        String s1 = reader.readLine();
        LogIn.username=s;
        LogIn.password=s1;
        boolean log = new LogIn().log();
        if (log == true) {
            System.out.println("登陆成功");
        } else {
            System.out.println("密码错误");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}

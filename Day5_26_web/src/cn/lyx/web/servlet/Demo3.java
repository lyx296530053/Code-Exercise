package cn.lyx.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/demo3")
public class Demo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        BufferedReader reader = request.getReader();
        String line=null;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()){
//            String s = headerNames.nextElement();
//            String header = request.getHeader(s);
//            System.out.println(s+"-----"+header);
//        }
//        String header = request.getHeader("user-agent");
//        if(header.contains("Chrome")){
//            System.out.println("chrome");

    }
    }


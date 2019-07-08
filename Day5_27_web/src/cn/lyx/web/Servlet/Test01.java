package cn.lyx.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test1")
public class Test01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method = request.getMethod();
//        System.out.println(method);
//        String requestURI = request.getRequestURI();
//        System.out.println(requestURI);
//        StringBuffer requestURL = request.getRequestURL();
//        System.out.println(requestURL);
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String s = headerNames.nextElement();
//            System.out.println(request.getHeader(s));
//        }
        String header = request.getHeader("user-agent");
        if (header.contains("Chrome")) {
            System.out.println("This is chrome");
        }
        String referer = request.getHeader("referer");
        if(referer.contains("/localhost")){
            System.out.println("欢迎观看");
        }
request.setAttribute("test2",1234);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}

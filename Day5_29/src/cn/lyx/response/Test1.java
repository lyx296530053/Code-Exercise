package cn.lyx.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test1")
public class Test1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("tese01");
        response.setStatus(302);
        response.setHeader("hello", "/Day5_29/test2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("gbk");
//        response.setHeader("content-type","text/html;charset=utf-8");
        System.out.println("tese02");
       response.sendRedirect("/day5_29/test2");
    }
}

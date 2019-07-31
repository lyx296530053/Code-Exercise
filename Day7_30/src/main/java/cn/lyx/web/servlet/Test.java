package cn.lyx.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class Test  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie=new Cookie("test","test");
        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();
        cookie.setMaxAge(60);
        HttpSession session = request.getSession();
    }
}

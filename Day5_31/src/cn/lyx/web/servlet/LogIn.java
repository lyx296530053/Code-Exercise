package cn.lyx.web.servlet;


import cn.lyx.daomain.admin;
import cn.lyx.service.UserService;
import cn.lyx.service.userImpl.Imply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LogIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String yan = (String) session.getAttribute("yan");
        session.removeAttribute("yan");
        String verifycode = request.getParameter("verifycode");
        if (yan.equals(verifycode)) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            admin admin = new admin();
            admin.setUsername(user);
            admin.setPassword(password);
            UserService service = new Imply();
           admin admin1 = service.logIn(admin);
            if (admin1 != null) {
                request.getRequestDispatcher("/userListServlet").forward(request, response);
                HttpSession session1 = request.getSession();
                session1.setAttribute("user",admin1);
            }else {
                request.setAttribute("mima","密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("mima","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package cn.lyx.web.servlet;

import cn.lyx.JDBC.User;

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        String yan = (String) session.getAttribute("yan");
        request.removeAttribute("checkCode");
        if (!yan.equals(checkCode)) {
            request.setAttribute("cc_error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        cn.lyx.JDBC.LogIn logIn = new cn.lyx.JDBC.LogIn();
        User log = logIn.log(user);
        if (log != null) {
            session.setAttribute("user", log);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            request.setAttribute("login_error", "密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

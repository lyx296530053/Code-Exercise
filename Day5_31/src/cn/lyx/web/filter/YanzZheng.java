package cn.lyx.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class YanzZheng implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (
                request.getRequestURI().contains("/index.jsp") ||
                        request.getRequestURI().contains("/login") ||
                        request.getRequestURI().contains("/css/") ||
                        request.getRequestURI().contains("/js/") ||
                        request.getRequestURI().contains("/fonts/") ||
                        request.getRequestURI().contains("/yanzheng") ||
                        request.getRequestURI().contains("/login.jsp")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = ((HttpServletRequest) req).getSession();
            if (session.getAttribute("user") != null) {
                chain.doFilter(req, resp);
            } else {
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
                chain.doFilter(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

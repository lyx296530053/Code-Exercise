package cn.lyx.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.FileReader;
//@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/敏感词汇.txt");
        try {
            String str= null;
            BufferedReader bb=new BufferedReader(new FileReader(realPath));
            while((str=bb.readLine())!=null){
                System.out.println(str);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
